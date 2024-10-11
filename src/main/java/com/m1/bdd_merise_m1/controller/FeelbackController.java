package com.m1.bdd_merise_m1.controller;

import com.m1.bdd_merise_m1.dto.StatDTO;
import com.m1.bdd_merise_m1.repository.*;
import com.m1.bdd_merise_m1.service.FeelbackService;
import org.springframework.beans.factory.annotation.Autowired;
import com.m1.bdd_merise_m1.entity.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeelbackController {

    @Autowired
    private FeelbackService feelbackService;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<StatDTO> stats = feelbackService.getStats();
        model.addAttribute("stats", stats);
        
        return "dashboard";
    }

    @GetMapping("/questionnaire")
    public String questionnaire(Model model, HttpServletRequest request) {
        List<Question> questions = questionRepository.findAll();
        model.addAttribute("questions", questions);

        if(userRepository.findAll().isEmpty()){
            feelbackService.addTestDataInDB();
        }

        Feedback f = new Feedback();
        f.setOrder(orderRepository.findAll().get(0));

        f = feedbackRepository.save(f);

        request.getSession().setAttribute("feedback", f);

        return "questionnaire";
    }

    @PostMapping("/reponse")
    public String reponse(HttpServletRequest request) {
        List<Question> questions = questionRepository.findAll();

        Feedback f = (Feedback) request.getSession().getAttribute("feedback");

        for (Question question : questions) {
            String response = request.getParameter("question_" + question.getId());

            System.out.println("Réponse pour la question " + question.getLabel() + " : " + response);

            Answer a = new Answer();
            a.setQuestion(question);
            a.setScore(Integer.valueOf(response));
            a.setFeedback(f);
            answerRepository.save(a);
        }
        return "index";
    }

    @GetMapping("/delete_data")
    public String deleteData() {
        feelbackService.deleteTestDataInDB();
        return "dashboard";
    }
}
