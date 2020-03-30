package com.StudyGuide.StudyGuide.dao.model.entity.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


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

       @ManyToMany
    @JoinTable(
            name="user_test",
            joinColumns = @JoinColumn(name="user_user_id"),
            inverseJoinColumns = @JoinColumn(name="test_test_id")
    )

    private List<Test> userTest;
    public User(){}

    public User(Long userId, @NotNull String email, @NotNull String uname, @NotNull String password, String firstName, String lastName, List<Test> userTest) {
        this.userId = userId;
        this.email = email;
        this.uname = uname;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userTest = userTest;
    }
}
