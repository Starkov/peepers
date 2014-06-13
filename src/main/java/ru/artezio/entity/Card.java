package ru.artezio.entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    private int id;
    private String phrase;
    private String translation;

    @Id
    @Column(name="idcard")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "phrases",nullable = false)
    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Column(name = "translations",nullable = false)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
