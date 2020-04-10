package com.StudyGuide.StudyGuide.service.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Questions;
import com.StudyGuide.StudyGuide.dao.repository.test.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public  Questions addQuestion(Questions question){
        Questions questionInstance = questionRepository.getOne(question.getQuestionId());
        if(questionInstance== null){
            return questionInstance;
        }
        else return question;
    }
}
