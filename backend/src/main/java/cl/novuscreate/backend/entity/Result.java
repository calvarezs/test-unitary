package cl.novuscreate.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="results", uniqueConstraints = @UniqueConstraint(columnNames = "RESULT_ID"))
public class Result {

    private int resultId;
    private String resultType;
    private String resultValue;
    @JsonIgnore
    private Example example;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "RESULT_ID", unique = true, nullable = false)
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }
    @Column(name = "RESULT_TYPE", nullable = false)
    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Column(name = "RESULT_VALUE", nullable = false)
    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXAMPLE_ID")
    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }
}
