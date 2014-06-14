package ru.artezio.entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    private int id;
    private String phrase;
    private String translation;
    private String user;
    @Column(name = "user_id", nullable = false)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Id
    @Column(name="idcard")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "phrase",nullable = false)
    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Column(name = "translation",nullable = false)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
