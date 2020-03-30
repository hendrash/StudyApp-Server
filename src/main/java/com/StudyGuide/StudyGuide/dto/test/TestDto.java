package com.StudyGuide.StudyGuide.dto.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Questions;
import com.StudyGuide.StudyGuide.dto.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class TestDto {
private Long testId;
private String testName;
private List<UserDto> user;
private List<Questions> testQuestions;

}
