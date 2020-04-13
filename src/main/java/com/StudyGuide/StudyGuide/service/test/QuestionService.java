package com.StudyGuide.StudyGuide.service.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Questions;
import com.StudyGuide.StudyGuide.dao.repository.test.QuestionRepository;
import com.StudyGuide.StudyGuide.dao.repository.test.TestRepository;
import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestRepository testRepository;
    @Autowired
    ModelMapper modelMapper;

    public  Questions addQuestion(Questions question){
        Questions questionInstance = questionRepository.getOne(question.getQuestionId());
        if(questionInstance== null){
            return questionInstance;
        }
        else return question;
    }


    public QuestionsDto create(QuestionsDto questionsDto){
        Questions questions = modelMapper.map(questionsDto, Questions.class);
        questionRepository.save(questions);
        return questionsDto;
    }

    public List<QuestionsDto> getAll(Long testId){
        return testRepository.getOne(testId).getQuestions().stream().map(t->{
            return modelMapper.map(t,QuestionsDto.class);
        }).collect(Collectors.toList());
    }

    public void delete(Long questionId){
        questionRepository.deleteById(questionId);
    }
    public QuestionsDto edit(QuestionsDto questionsDto){
        Questions questions = questionRepository.getOne(questionsDto.getQuestionId());
        questions.edit(questionsDto);
        questionRepository.save(questions);
        return questionsDto;
    }
}
