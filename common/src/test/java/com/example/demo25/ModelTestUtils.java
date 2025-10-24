package com.example.demo25;

import com.example.demo25.model.*;
import com.example.demo25.persistence.enums.IngredientType;
import com.example.demo25.persistence.enums.RecipeType;
import com.example.demo25.persistence.enums.Unit;
import com.example.demo25.utils.DateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.LongStream;

import static com.example.demo25.TestConstants.*;

public class ModelTestUtils {

    private ModelTestUtils() {
    }

    /**
     * Build a User object for testing
     * <ul>
     *     <li>Id: ordinal</li>
     *     <li>First Name: "fName" + ordinal</li>
     *     <li>Last Name: "lName" + ordinal</li>
     *     <li>Email: "email" + ordinal + "@test.com"</li>
     *     <li>Birth Date: Current date minus (10 * ordinal) years</li>
     *     <li>Inscription Date: Current date minus ordinal months</li>
     * </ul>
     *
     * @param ordinal the ordinal to differentiate users
     * @return the User object
     */
    public static User buildUser(Long ordinal) {
        return new User(ordinal,
            FIRST_NAME.formatted(ordinal),
            LAST_NAME.formatted(ordinal),
            EMAIL.formatted(ordinal),
            DateUtils.formatLocalDate(LocalDate.now().minusYears(10 * ordinal)),
            DateUtils.formatLocalDate(LocalDate.now().minusMonths(ordinal)));
    }

    /**
     * Build a list of User objects for testing
     *
     * @param count the number of users to create
     * @return the list of User objects
     */
    public static List<User> buildUserList(int count) {
        return LongStream.rangeClosed(1L, count).mapToObj(ModelTestUtils::buildUser).toList();
    }

    /**
     * Build a Product object for testing
     * <ul>
     *     <li>Id: ordinal</li>
     *     <li>Name: "Product" + ordinal</li>
     *     <li>Ingredient Type: IngredientType corresponding to (ordinal - 1) index</li>
     * </ul>
     *
     * @param ordinal the ordinal to differentiate products
     * @return the Product object
     */
    public static Product buildProduct(Long ordinal) {
        return new Product(ordinal, PRODUCT_NAME.formatted(ordinal), IngredientType.getByIndex(ordinal.intValue() - 1));
    }

    /**
     * Build a list of Product objects for testing
     *
     * @param count the number of products to create
     * @return the list of Product objects
     */
    public static List<Product> buildProductList(int count) {
        if (count > IngredientType.values().length) {
            count = IngredientType.values().length;
        }
        return LongStream.rangeClosed(1L, count).mapToObj(ModelTestUtils::buildProduct).toList();
    }

    /**
     * Build a Step object for testing
     * <ul>
     *     <li>Id: ordinal</li>
     *     <li>Description: "Step description " + ordinal</li>
     *     <li>Duration: ordinal as int</li>
     * </ul>
     *
     * @param ordinal the ordinal to differentiate steps
     * @return the Step object
     */
    public static Step buildStep(Long ordinal) {
        return new Step(ordinal, STEP_DESCRIPTION.formatted(ordinal), ordinal.intValue());
    }

    /**
     * Build a list of Step objects for testing
     *
     * @param count the number of steps to create
     * @return the list of Step objects
     */
    public static List<Step> buildStepList(int count) {
        return LongStream.rangeClosed(1L, count).mapToObj(ModelTestUtils::buildStep).toList();
    }

    /**
     * Build an Ingredient object for testing
     * <ul>
     *     <li>Id: ordinal</li>
     *     <li>Quantity: ordinal * 10 as double</li>
     *     <li>Unit: Unit corresponding to (ordinal - 1) index</li>
     *     <li>Product: Product object built with the same ordinal</li>
     * </ul>
     *
     * @param ordinal the ordinal to differentiate ingredients
     * @return the Ingredient object
     */
    public static Ingredient buildIngredient(Long ordinal) {
        return new Ingredient(ordinal,
            ordinal.doubleValue() * 10,
            Unit.getByIndex(ordinal.intValue() - 1),
            buildProduct(ordinal));
    }

    /**
     * Build a list of Ingredient objects for testing
     *
     * @param count the number of ingredients to create
     * @return the list of Ingredient objects
     */
    public static List<Ingredient> buildIngredientList(int count) {
        if (count > Unit.values().length) {
            count = Unit.values().length;
        }
        return LongStream.rangeClosed(1L, count).mapToObj(ModelTestUtils::buildIngredient).toList();
    }

    public static Recipe buildRecipe(Long ordinal) {
        return new Recipe(ordinal,
            RECIPE_TITLE.formatted(ordinal),
            RECIPE_DESCRIPTION.formatted(ordinal),
            ordinal.intValue() * 40,
            RecipeType.getByIndex(ordinal.intValue() - 1),
            DateUtils.formatLocalDate(LocalDate.now().minusDays(10 * ordinal)),
            buildUser(ordinal),
            buildIngredientList(5),
            buildStepList(5));
    }
}
