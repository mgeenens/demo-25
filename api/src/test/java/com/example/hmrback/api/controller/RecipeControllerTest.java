package com.example.hmrback.api.controller;

import com.example.hmrback.auth.service.JwtService;
import com.example.hmrback.model.Recipe;
import com.example.hmrback.persistence.entity.RecipeEntity;
import com.example.hmrback.persistence.entity.RoleEntity;
import com.example.hmrback.persistence.entity.UserEntity;
import com.example.hmrback.persistence.enums.RoleEnum;
import com.example.hmrback.persistence.repository.RecipeRepository;
import com.example.hmrback.persistence.repository.UserRepository;
import com.example.hmrback.utils.test.EntityTestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("localtest")
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String adminToken;
    private String userToken;
    private String otherToken;
    private RecipeEntity recipeEntity;

    private static Recipe recipeRequest; // TODO dans BefaoreAll + ObjectMapper -> class IntegrationTestUtils

    @BeforeEach
    void setup() {
        // Create test user and admin in DB (or mock them)
        UserEntity user = EntityTestUtils.buildUserEntity(1L);
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(Set.of(new RoleEntity(1L, RoleEnum.ROLE_USER)));
        userRepository.save(user);

        UserEntity admin = EntityTestUtils.buildUserEntity(2L);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("adminpass"));
        admin.setRoles(Set.of(new RoleEntity(1L, RoleEnum.ROLE_ADMIN)));
        userRepository.save(admin);

        // Create a different user without author role
        UserEntity otherUser = EntityTestUtils.buildUserEntity(3L);
        otherUser.setUsername("otherUser");
        otherUser.setPassword(passwordEncoder.encode("password"));
        otherUser.setRoles(Set.of(new RoleEntity(1L, RoleEnum.ROLE_USER)));
        userRepository.save(otherUser);

        // Generate JWT tokens for them
        adminToken = jwtService.generateToken(admin);
        userToken = jwtService.generateToken(user);
        otherToken = jwtService.generateToken(otherUser);

        // Create a recipe authored by "user1"
        recipeEntity = EntityTestUtils.buildRecipeEntity(1L);
        recipeEntity.setAuthor(user);
        recipeRepository.save(recipeEntity);
    }

    // TODO: other tests

    @Test
    @Order(1)
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void updateRecipe_AsAdmin_ShouldSucceed() throws Exception {
        mockMvc.perform(put("/hmr/api/recipes/" + recipeEntity.getId())
                .header("Authorization", "Bearer " + adminToken)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Updated by Admin\"}"))
            .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    @WithMockUser(username = "username1")
    void updateRecipe_AsAuthor_ShouldSucceed() throws Exception {
        mockMvc.perform(put("/hmr/api/recipes/" + recipeEntity.getId())
                .header("Authorization", "Bearer " + userToken)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Updated by Author\"}"))
            .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    @WithMockUser(username = "otherUser")
    void updateRecipe_AsOtherUser_ShouldFail() throws Exception {
        mockMvc.perform(put("/hmr/api/recipes/" + recipeEntity.getId())
                .header("Authorization", "Bearer " + otherToken)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Malicious Update\"}"))
            .andExpect(status().isForbidden());
    }

    @Test
    @Order(4)
    @WithMockUser(username = "username1")
    void deleteRecipe_AsAuthor_ShouldSucceed() throws Exception {
        mockMvc.perform(delete("/hmr/api/recipes/" + recipeEntity.getId())
                .header("Authorization", "Bearer " + userToken))
            .andExpect(status().isNoContent());
    }

    @Test
    @Order(5)
    @WithMockUser(username = "otherUser")
    void deleteRecipe_AsOtherUser_ShouldFail() throws Exception {
        mockMvc.perform(delete("/hmr/api/recipes/" + recipeEntity.getId())
                .header("Authorization", "Bearer " + otherToken))
            .andExpect(status().isForbidden());
    }

}
