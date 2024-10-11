package com.m1.bdd_merise_m1.repository;

import com.m1.bdd_merise_m1.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}