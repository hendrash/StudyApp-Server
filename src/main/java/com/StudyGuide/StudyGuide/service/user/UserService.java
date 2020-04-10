package com.StudyGuide.StudyGuide.service.user;
import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dao.repository.test.TestRepository;
import com.StudyGuide.StudyGuide.dao.repository.user.UserRepository;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import com.StudyGuide.StudyGuide.service.test.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TestService testService;

    public User addUser(User user){
        User userInstance = userRepository.getOne(user.getUserId());
        if(userInstance==null){
            return user;
        }
        else return userInstance;
    }

    public UserDto createUser(UserDto userDto){
    User user = modelMapper.map(userDto, User.class);
        if(user.getUserTest()!=null)
            userDto.getTestIds().stream().map(t->
                testService.addTest(testRepository.getOne(t))
            ).collect(Collectors.toSet());
        userRepository.save(user);
        return userDto;
    }

    public List<UserDto> getUsers(){

    return userRepository.findAll().stream().map(t->{
        UserDto userDto =modelMapper.map(t, UserDto.class);
        userDto.setTestIds( t.getUserTest().stream().map(a->a.getTestId()).collect(Collectors.toSet()));
        return userDto;}).collect(Collectors.toList());
}
    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    public UserDto edit(UserDto userDto){
        User user = userRepository.getOne(userDto.getUserId());
        user.edit(modelMapper.map(userDto, User.class));
        userRepository.save(user);
        return userDto;
    }
}
