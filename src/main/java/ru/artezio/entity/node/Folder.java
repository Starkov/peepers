package ru.artezio.entity.node;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Folder extends Node implements java.io.Serializable {

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @OneToMany(mappedBy = "folder", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Folder> childFolderList = new LinkedList<Folder>();

    @OneToMany(mappedBy = "parentFolder", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Card> childCardList = new LinkedList<Card>();

    public List<Folder> getChildFolderList() {
        return childFolderList;
    }

    public void setChildFolderList(List<Folder> childList) {
        this.childFolderList = childList;
    }

    @XmlTransient
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public List<Card> getChildCardList() {
        return childCardList;
    }

    public void setChildCardList(List<Card> childCardList) {
        this.childCardList = childCardList;
    }
}
