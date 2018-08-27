package cl.novuscreate.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "USER_ID"))
public class User {


    private int userId;
    private String userEmail;
    private String userPassword;
    private int userType = -1;

    @JsonIgnore
    private Set<Problem> problems = new HashSet<Problem>(0);;

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserProblem> userProblems = new HashSet<UserProblem>();


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID", unique = true, nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USER_EMAIL", unique = true, nullable = false)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "USER_PASSWORD", nullable = false)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Column(name = "USER_TYPE", nullable = false)
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval=true)
    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval=true)
    public Set<UserProblem> getUserProblems() {
        return userProblems;
    }

    public void setUserProblems(Set<UserProblem> userProblems) {
        this.userProblems = userProblems;
    }


//    public void addProblem(Problem problem) {
////        UserProblem userProblem = new UserProblem(this, problem);
////        userProblems.add(userProblem);
////        problem.getUsers().add(userProblem);
////    }

    public boolean verificateUser(){
        if(getUserEmail() == null)
            return false;
        if (getUserType() < 0)
            return false;

        return true;
    }
}