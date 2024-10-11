package com.m1.bdd_merise_m1.service;

import com.m1.bdd_merise_m1.dto.StatDTO;
import com.m1.bdd_merise_m1.entity.Answer;
import com.m1.bdd_merise_m1.entity.Order;
import com.m1.bdd_merise_m1.entity.Product;
import com.m1.bdd_merise_m1.entity.Question;
import com.m1.bdd_merise_m1.entity.User;
import com.m1.bdd_merise_m1.repository.AnswerRepository;
import com.m1.bdd_merise_m1.repository.FeedbackRepository;
import com.m1.bdd_merise_m1.repository.OrderRepository;
import com.m1.bdd_merise_m1.repository.ProductRepository;
import com.m1.bdd_merise_m1.repository.QuestionRepository;
import com.m1.bdd_merise_m1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeelbackServiceImpl implements FeelbackService {
    
    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<StatDTO> getStats() {
        List<Question> questions = questionRepository.findAll();
        List<StatDTO> stats = new ArrayList<>();
        
        for (Question question : questions) {
            List<Answer> answers = answerRepository.findByQuestionId(question.getId());
            double total = 0;
            for (Answer answer : answers) {
                total += answer.getScore();
            }
            double average = total / answers.size();
            stats.add(new StatDTO(question.getTitle(), average));
        }
        
        Double totalAnswers = (double) feedbackRepository.findAll().size();
        StatDTO totalStat = new StatDTO("Réponses", totalAnswers);
        stats.add(0, totalStat);
        
        return stats;
    }
    
    @Override
    public void addTestDataInDB() {
        User user = new User();
        user.setEmail("user.test@test.com");
        user.setName("User Test");
        userRepository.save(user);

        Product p1 = new Product();
        p1.setName("TV");
        p1.setPriceHt(BigDecimal.valueOf(500));
        p1.setFragile(true);
        p1.setId(1);
        productRepository.save(p1);
        
        Product p2 = new Product();
        p2.setName("Smartphone");
        p2.setPriceHt(BigDecimal.valueOf(700));
        p2.setFragile(false);
        p2.setId(2);
        productRepository.save(p2);

        Order order = new Order();
        order.setId(1);
        order.setUser(user);
        order.setTotalPrice(p1.getPriceHt().add(p2.getPriceHt()));
        orderRepository.save(order);
    }
}
