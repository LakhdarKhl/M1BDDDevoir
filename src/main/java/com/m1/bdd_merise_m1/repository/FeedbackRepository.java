package com.m1.bdd_merise_m1.repository;

import com.m1.bdd_merise_m1.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}