package ru.artezio.entity.node;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Card extends Node implements java.io.Serializable {

    @Column(name = "translation")
    private String translation;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder parentFolder;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @XmlTransient
    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }
}
