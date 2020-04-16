package com.StudyGuide.StudyGuide.dto.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property="questionId",
        scope = QuestionsDto.class
)
@JsonDeserialize(as = QuestionsDto.class)
public class QuestionsDto {
    private Long questionId;
    private String question;
    private Long testId;
    private String hint;
    Set<AnswerDto> answer;
    QuestionsDto(){}
}
