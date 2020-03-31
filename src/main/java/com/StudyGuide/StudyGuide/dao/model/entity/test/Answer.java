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

//    @ManyToMany(mappedBy = "questionAnswers", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    List<Questions> testQuestions;




}
