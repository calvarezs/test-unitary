package cl.novuscreate.backend.CompositePK;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserProblemId implements Serializable {

    @Column(name = "post_id")
    private int userId;

    @Column(name = "tag_id")
    private int problemId;

    private UserProblemId() {}

    public UserProblemId(
            Integer userId,
            Integer problemId) {
        this.userId = userId;
        this.problemId = problemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserProblemId that = (UserProblemId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(problemId, that.problemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, problemId);
    }
}
