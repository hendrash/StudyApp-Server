package com.StudyGuide.StudyGuide.dto.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.StudyGuide.StudyGuide.dto.test.TestDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter @Getter
public class UserDto {

    private Long userId;

    private String email;
    private String uname;
    private String firstName;
    private String lastName;
    private List<TestDto> userTest;
    UserDto(){}
    UserDto(Long userId, String email, String uname, String firstName, String lastName, List<TestDto> userTest){
        this.userId= userId;
        this.email=email;
        this.uname= uname;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userTest=userTest;
    }

}
