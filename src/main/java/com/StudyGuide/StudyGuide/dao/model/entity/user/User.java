package com.StudyGuide.StudyGuide.dao.model.entity.user;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;

import java.util.Set;


@Entity
@Setter @Getter
@Table(name="user", uniqueConstraints = {
        @UniqueConstraint(name = "uq_user_id",columnNames = {"uname"})
})

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

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @ManyToMany(mappedBy = "testUser")
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
    public User edit(User user){
           this.firstName=user.getFirstName();
           this.lastName= user.getLastName();
           this.email= user.getEmail();
           this.uname=user.getUname();
           return this;
    }
}
