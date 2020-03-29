package com.StudyGuide.StudyGuide.dao.model.entity.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="user", uniqueConstraints = {
        @UniqueConstraint(name="uq_email",columnNames = {"email"})
})
public class User {
    @Column(name="user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long userId;

    @Column(name="email")
    @Getter @Setter
    @NotNull
    private String email;

    @Column(name="uname")
    @Getter @Setter
    @NotNull
    private String uname;

    @Column(name="password")
    @Setter @Getter
    @NotNull
    private String password;

    @Column(name="first_name")
    @Setter @Getter
    private String firstName;

    @Column(name="last_name")
    @Setter @Getter
    private String lastName;

    @ManyToMany
            @JoinTable(
                    name="user_test",
                    joinColumns = @JoinColumn(name="user_user_id"),
                    inverseJoinColumns = @JoinColumn(name="test_test_id")
            )
            @Setter @Getter
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
