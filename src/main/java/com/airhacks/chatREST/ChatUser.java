/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.chatREST;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nataliat
 */
@Entity
@Table(name = "chat_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatUser.findAll", query = "SELECT c FROM ChatUser c"),
    @NamedQuery(name = "ChatUser.findById", query = "SELECT c FROM ChatUser c WHERE c.id = :id"),
    @NamedQuery(name = "ChatUser.findByHandle", query = "SELECT c FROM ChatUser c WHERE c.handle = :handle")})
public class ChatUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "handle")
    private String handle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ChatLine> chatLineCollection;

    public ChatUser() {
    }

    public ChatUser(Integer id) {
        this.id = id;
    }

    public ChatUser(Integer id, String handle) {
        this.id = id;
        this.handle = handle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @XmlTransient
    public Collection<ChatLine> getChatLineCollection() {
        return chatLineCollection;
    }

    public void setChatLineCollection(Collection<ChatLine> chatLineCollection) {
        this.chatLineCollection = chatLineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatUser)) {
            return false;
        }
        ChatUser other = (ChatUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.chatREST.ChatUser[ id=" + id + " ]";
    }
    
}
