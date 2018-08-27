package cl.novuscreate.backend.entity;


import cl.novuscreate.backend.CompositePK.UserProblemId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "UserProblem")
@Table(name = "user_problem")
public class UserProblem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_PROBLEM_ID", unique = true, nullable = false)
    private Integer userProblemId;

    private User user;

    private Problem problem;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Column(name = "statusComplete", nullable = false)
    private Integer statusComplete;

    private Solution solution;

    private UserProblem() {}


    private String feedback;

    public UserProblem(User user, Problem problem, Integer statusComplete) {
        this.user = user;
        this.problem = problem;
        this.statusComplete = statusComplete;
    }

    public UserProblem(User user, Problem problem, Date createdOn, Integer statusComplete, Solution solution) {
        this.user = user;
        this.problem = problem;
        this.createdOn = createdOn;
        this.statusComplete = statusComplete;
        this.solution = solution;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USERPROBLEM_ID", unique = true, nullable = false)
    public Integer getUserProblemId() {
        return userProblemId;
    }

    public void setUserProblemId(Integer userProblemId) {
        this.userProblemId = userProblemId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROBLEM_ID")
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getStatusComplete() {
        return statusComplete;
    }

    public void setStatusComplete(Integer statusComplete) {
        this.statusComplete = statusComplete;
    }

    @Column(name = "feedback",columnDefinition = "TEXT")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOLUTION_ID")
    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserProblem that = (UserProblem) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(problem, that.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, problem);
    }


}
