package ru.artezio.entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    private Integer id;
    private String phrase;
    private String translation;
    private String user;

    @Id
    @Column(name = "idcard")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "phrase", nullable = false)
    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Column(name = "translation", nullable = false)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Column(name = "user_id", nullable = false)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
