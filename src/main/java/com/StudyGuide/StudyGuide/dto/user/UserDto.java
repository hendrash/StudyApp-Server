package com.StudyGuide.StudyGuide.dto.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dto.test.TestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter @Getter
@JsonDeserialize(as= UserDto.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userId")
public class UserDto {

    private Long userId;
    private String email;
    private String uname;
    private String firstName;
    private String lastName;
    private String password;
   // @JsonBackReference
    private Set<Long> testIds;
    UserDto(){}
    UserDto(Long userId, String email, String uname, String password, String firstName, String lastName,
            HashSet<Long> testIds){
        this.userId= userId;
        this.email=email;
        this.uname= uname;
        this.firstName=firstName;
        this.lastName=lastName;
        this.testIds=testIds;
    }

}
