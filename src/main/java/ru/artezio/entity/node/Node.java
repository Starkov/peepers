package ru.artezio.entity.node;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "nodes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Node implements java.io.Serializable {

    @Transient
    private Integer parentHolderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentHolderId() {
        return parentHolderId;
    }

    public void setParentHolderId(Integer parentHolderId) {
        this.parentHolderId = parentHolderId;
    }
}
