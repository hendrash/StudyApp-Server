package com.StudyGuide.StudyGuide.service.user;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dao.repository.user.UserRepository;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

public UserDto createUser(UserDto userDto){
    User user = modelMapper.map(userDto, User.class);
    System.out.println(userDto.getUserTest().get(0).getTestName());
    userRepository.save(user);
    return userDto;
}
public List<UserDto> getUsers(){
    return userRepository.findAll().stream().map(t->modelMapper.map(t, UserDto.class)).collect(Collectors.toList());
}
}
