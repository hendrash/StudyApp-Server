package com.StudyGuide.StudyGuide.dao.model.entity.test;


import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="question") @Setter @Getter
public class Questions {
    @Column(name="question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name="question")
    private String question;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name="test_id", referencedColumnName = "test_id", foreignKey=@ForeignKey(name="fk_test_id"))
    Test testQuestions;

    @OneToMany(mappedBy = "questionAnswers")
    private Set<Answer> Answer;

    public Questions edit(QuestionsDto questionDto){
        this.question=questionDto.getQuestion();
        return this;
    }
 }

