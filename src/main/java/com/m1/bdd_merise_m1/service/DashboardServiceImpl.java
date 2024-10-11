package com.m1.bdd_merise_m1.service;

import com.m1.bdd_merise_m1.dto.StatDTO;
import com.m1.bdd_merise_m1.entity.Answer;
import com.m1.bdd_merise_m1.entity.Question;
import com.m1.bdd_merise_m1.repository.AnswerRepository;
import com.m1.bdd_merise_m1.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    
    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<StatDTO> getStats() {
        List<Question> questions = questionRepository.findAll();
        List<StatDTO> stats = new ArrayList<>();
        
        Double totalAnswers = 0.0;
        for (Question question : questions) {
            List<Answer> answers = answerRepository.findByQuestionId(question.getId());
            double total = 0;
            for (Answer answer : answers) {
                total += answer.getScore();
            }
            totalAnswers++;
            double average = total / answers.size();
            stats.add(new StatDTO(question.getTitle(), average));
        }
         
        StatDTO totalStat = new StatDTO("Réponses", totalAnswers);
        stats.add(0, totalStat);
        
        return stats;
    }
    
}
