package com.StudyGuide.StudyGuide.dao.model.entity.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Setter @Getter
@Table(name="user")

public class User {
    @Column(name="user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="uname")
    @NotNull
    private String uname;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

       @ManyToMany(fetch=FetchType.LAZY, cascade = {
               CascadeType.PERSIST,
               CascadeType.MERGE
       })
    @JoinTable(
            name="user_test",
            joinColumns = @JoinColumn(name="user_user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="test_test_id", referencedColumnName = "test_id")
    )

    private Set<Test> userTest  = new HashSet<Test>();
    public User(){}

    public User(Long userId, @NotNull String email, @NotNull String uname, @NotNull String password, String firstName, String lastName, Set<Test> userTest) {
        this.userId = userId;
        this.email = email;
        this.uname = uname;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTest = userTest;
    }
}
