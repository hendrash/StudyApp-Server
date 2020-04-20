package com.StudyGuide.StudyGuide.dao.model.entity.test;


import com.StudyGuide.StudyGuide.dto.test.AnswerDto;
import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="answer")
@Setter @Getter
public class Answer {
    @Column(name="answer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long answerId;

    @Column(name ="correct")
    private Boolean correct;

    @Column(name="description")
    private String description;
    @NotNull
    @Column(name="answer")
    private String answer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="question_Id", referencedColumnName = "question_Id", foreignKey = @ForeignKey(name="fk_question_Id"))
    Questions questionAnswers;

    public Answer edit(AnswerDto answerDto){
        this.description=answerDto.getDescription();
        this.answer=answerDto.getAnswer();
        this.correct=answerDto.getCorrect();
        return this;
    }
}
