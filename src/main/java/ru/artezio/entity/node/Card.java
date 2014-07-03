package ru.artezio.entity.node;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Card extends Node implements java.io.Serializable {

    @Column(name = "translation")
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
