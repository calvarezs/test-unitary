package cl.novuscreate.backend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="inputs", uniqueConstraints = @UniqueConstraint(columnNames = "INPUT_ID"))
public class Input {

    private int inputId;
    private String inputType;
    private String inputValue;
    private Example example;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "INPUT_ID", unique = true, nullable = false)
    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    @Column(name = "INPUT_TYPE", nullable = false)
    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @Column(name = "INPUT_VALUE", nullable = false)
    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXAMPLE_ID")
    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }
}
