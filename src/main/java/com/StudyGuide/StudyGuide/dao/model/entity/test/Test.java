package com.StudyGuide.StudyGuide.dao.model.entity.test;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="test")
public class Test {

@Column(name="test_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Setter @Getter
private Long testId;

@Column(name="test_name")
@Setter @Getter
private String testName;

@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY) @Getter @Setter
    @JoinTable(
            name="test_question",
            joinColumns = @JoinColumn(name="test_test_id"),
            inverseJoinColumns = @JoinColumn(name="question_question_id")
    )
List<Questions> testQuestions;

@Setter @Getter
@ManyToMany(mappedBy = "userTest")
List<User> testUser;
}
