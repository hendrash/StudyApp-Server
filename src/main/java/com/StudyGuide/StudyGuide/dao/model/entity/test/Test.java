package com.StudyGuide.StudyGuide.dao.model.entity.test;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import com.StudyGuide.StudyGuide.dto.test.TestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="test")@Setter @Getter
public class Test {
    public Test(){}

@Column(name="test_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long testId;

@Column(name="test_name")
private String testName;



    @ManyToMany(fetch=FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="test_user",
            joinColumns = @JoinColumn(name="test_id", referencedColumnName = "test_id"),
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "user_id")
    )
    Set<User> testUser;

    @OneToMany(mappedBy = "testQuestions", cascade={CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    private Set<Questions> questions;

   public Test edit(TestDto test){
       this.testName=test.getTestName();
       return this;
    }

}
