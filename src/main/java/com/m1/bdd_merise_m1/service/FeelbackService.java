package com.m1.bdd_merise_m1.service;

import com.m1.bdd_merise_m1.dto.StatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeelbackService {

    List<StatDTO> getStats();
    
    void addTestDataInDB();
}
