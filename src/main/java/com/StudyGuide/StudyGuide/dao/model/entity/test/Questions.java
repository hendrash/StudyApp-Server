package com.StudyGuide.StudyGuide.dao.model.entity.test;


import com.StudyGuide.StudyGuide.dto.test.QuestionsDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@Table(name="question") @Setter @Getter
public class Questions {
    @Column(name="question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @NotNull
    @Column(name="question")
    private String question;

    @Column(name="hint")
    private String hint;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name="test_id", referencedColumnName = "test_id", foreignKey=@ForeignKey(name="fk_test_id"))
    Test testQuestions;

    @OneToMany(mappedBy = "questionAnswers", cascade={CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    private Set<Answer> answer;


    public Questions edit(QuestionsDto questionDto){
        this.question=questionDto.getQuestion();
        this.hint=questionDto.getHint();
        return this;
    }
 }

