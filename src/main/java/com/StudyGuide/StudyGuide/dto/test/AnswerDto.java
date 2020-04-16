package com.StudyGuide.StudyGuide.dto.test;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AnswerDto {
    private Long answerId;
    private Boolean correct;
    private String description;
    private String answer;
    private QuestionsDto questionAnswers;
    AnswerDto(){}
}
