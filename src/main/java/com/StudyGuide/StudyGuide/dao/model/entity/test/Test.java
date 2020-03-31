package com.StudyGuide.StudyGuide.dao.model.entity.test;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="test")@Setter @Getter
public class Test {

@Column(name="test_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long testId;

@Column(name="test_name")
private String testName;

public Test(){}


//@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY) @Getter @Setter
//    @JoinTable(
//            name="test_question",
//            joinColumns = @JoinColumn(name="test_test_id"),
//            inverseJoinColumns = @JoinColumn(name="question_question_id")
//    )
//List<Questions> testQuestions;
//
//@Setter @Getter
@ManyToMany(mappedBy = "userTest")
Set<User> testUser;
}
