package com.StudyGuide.StudyGuide.service.test;

import com.StudyGuide.StudyGuide.dao.repository.test.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
public void delete(Long answerId){
    answerRepository.deleteById(answerId);
}
}
