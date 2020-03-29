package com.StudyGuide.StudyGuide.dao.model.entity.test;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="question")
public class Questions {
    @Column(name="question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long questionId;

    @Column(name="question")
    @Getter @Setter
    private String Question;

    @Getter @Setter
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
            @JoinTable(
                    name="question_answer",
                    joinColumns = @JoinColumn(name="question_question_id"),
                    inverseJoinColumns =@JoinColumn(name="answer_answer_id")
            )
    List<Answer> questionAnswers;
    @Setter @Getter
    @ManyToMany(mappedBy = "testQuestions", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    List<Test> questionTest;
 }

