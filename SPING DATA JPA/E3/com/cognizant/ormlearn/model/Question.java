package com.cognizant.ormlearn.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @OneToMany(mappedBy = "question")
    private Set<Option> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", text=" + text + "]";
    }
}
