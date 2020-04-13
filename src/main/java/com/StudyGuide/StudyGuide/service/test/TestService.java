package com.StudyGuide.StudyGuide.service.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Questions;
import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dao.repository.test.TestRepository;
import com.StudyGuide.StudyGuide.dao.repository.user.UserRepository;
import com.StudyGuide.StudyGuide.dto.test.TestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    public Test addTest(Test test) {
        Test testInstance = testRepository.getOne(test.getTestId());
        if (testInstance == null) {

            return test;
        } else return testInstance;
    }

    public TestDto createTest(TestDto testDto){
        Test test = modelMapper.map(testDto, Test.class);

        if(test.getTestUser() != null) {
            test.setTestUser(testDto.getUserIds().stream().map(t -> {
                User userInstance = userRepository.findById(t).get();
                   if (userInstance != null)
                    return userInstance;
                return null;
            }).collect(Collectors.toSet()));

    }
        testRepository.save(test);
        return testDto;
    }


    public List<TestDto> getAll(Long userId){
         return userRepository.findById(userId).stream().flatMap(t->{
             return t.getUserTest().stream().map(i->{
                 TestDto testDto =modelMapper.map(i, TestDto.class);
                 List<Long> userIdList =new ArrayList<Long>();
                 userIdList.add(userId);
                 testDto.setUserIds(userIdList);
                return testDto;
             });

        }).collect(Collectors.toList());
    }

    public void delete(Long testId){testRepository.deleteById(testId);}

    public TestDto edit(TestDto testDto){
            Test test= testRepository.getOne(testDto.getTestId());
            test.edit(testDto);
            testRepository.save(test);
        return testDto;
    }
}