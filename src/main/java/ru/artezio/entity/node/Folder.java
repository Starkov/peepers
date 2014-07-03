package ru.artezio.entity.node;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Folder extends Node implements java.io.Serializable {

    @OneToMany(mappedBy = "folder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Node> childList = new LinkedList<Node>();

    @XmlElement
    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }
}
