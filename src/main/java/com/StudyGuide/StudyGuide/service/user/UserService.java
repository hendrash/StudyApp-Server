package com.StudyGuide.StudyGuide.service.user;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dao.repository.user.UserRepository;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

public UserDto createUser(UserDto userDto){
    User user = modelMapper.map(userDto, User.class);
    userRepository.save(user);
    return userDto;
}
}
