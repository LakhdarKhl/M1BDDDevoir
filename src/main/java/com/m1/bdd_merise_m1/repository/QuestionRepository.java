package com.m1.bdd_merise_m1.repository;

import com.m1.bdd_merise_m1.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}