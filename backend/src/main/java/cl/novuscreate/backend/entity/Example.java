package cl.novuscreate.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="examples", uniqueConstraints = @UniqueConstraint(columnNames = "EXAMPLE_ID"))
public class Example {

    private int exampleId;
    private String exampleTitle;
    private Problem problem;

    private Set<Input> exampleInputs;

    private Result result;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "EXAMPLE_ID", unique = true, nullable = false)
    public int getExampleId() {
        return exampleId;
    }

    public void setExampleId(int exampleId) {
        this.exampleId = exampleId;
    }

    @Column(name = "EXAMPLE_TITLE", nullable = false)
    public String getExampleTitle() {
        return exampleTitle;
    }

    public void setExampleTitle(String exampleTitle) {
        this.exampleTitle = exampleTitle;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROBLEM_ID")
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "example", orphanRemoval=true)
    @JsonManagedReference
    public Set<Input> getExampleInputs() {
        return exampleInputs;
    }

    public void setExampleInputs(Set<Input> problemInputs) {
        this.exampleInputs = problemInputs;
    }

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "example")
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
