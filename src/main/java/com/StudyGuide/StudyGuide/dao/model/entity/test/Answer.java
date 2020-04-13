package com.StudyGuide.StudyGuide.dao.model.entity.test;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name="answer")
    private String answer;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @JoinColumn(name="question_Id", referencedColumnName = "question_Id", foreignKey = @ForeignKey(name="fk_question_Id"))
    Questions questionAnswers;

}
