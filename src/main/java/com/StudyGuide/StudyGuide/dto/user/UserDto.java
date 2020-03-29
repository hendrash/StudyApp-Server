package com.StudyGuide.StudyGuide.dto.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserDto {
    @Setter @Getter
    private Long userId;
    @Setter @Getter
    private String email;
    @Setter @Getter
    private String uname;
    @Setter @Getter
    private String firstName;
    @Setter @Getter
    private String lastName;
    @Setter @Getter
    private List<Test> userTest;
    UserDto(){}
    UserDto(Long userId, String email, String uname, String firstName, String lastName, List<Test> userTest){
        this.userId= userId;
        this.email=email;
        this.uname= uname;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userTest=userTest;
    }
}
