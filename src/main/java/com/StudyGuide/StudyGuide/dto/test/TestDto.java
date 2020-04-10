package com.StudyGuide.StudyGuide.dto.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Questions;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "testId",
scope=TestDto.class)
@JsonDeserialize(as= TestDto.class)
public class TestDto {
private Long testId;
private String testName;
//@JsonManagedReference
private List<Long> userIds;

private List<QuestionsDto> questionIds;
TestDto(){}
}
