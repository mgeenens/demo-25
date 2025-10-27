package com.example.hmrback.persistence.repository;

import com.example.hmrback.persistence.entity.StepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StepRepository extends JpaRepository<StepEntity, Long>, QuerydslPredicateExecutor<StepEntity> {
}
