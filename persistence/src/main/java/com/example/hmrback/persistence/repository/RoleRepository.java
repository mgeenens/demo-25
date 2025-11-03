package com.example.hmrback.persistence.repository;

import com.example.hmrback.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>, QuerydslPredicateExecutor<RoleEntity> {
    Optional<RoleEntity> findByName(String name);
}
