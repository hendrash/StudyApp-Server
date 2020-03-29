package com.StudyGuide.StudyGuide.dao.model.entity.test;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="answer")
public class Answer {
    @Column(name="answer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long answerId;

    @Column(name ="correct")
    private Boolean correct;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "questionAnswers", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY) @Setter @Getter
    List<Questions> testQuestions;




}
