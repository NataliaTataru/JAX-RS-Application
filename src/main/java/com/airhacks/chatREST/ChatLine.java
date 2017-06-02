/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.chatREST;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nataliat
 */
@Entity
@Table(name = "chat_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChatLine.findAll", query = "SELECT c FROM ChatLine c"),
    @NamedQuery(name = "ChatLine.findById", query = "SELECT c FROM ChatLine c WHERE c.id = :id"),
    @NamedQuery(name = "ChatLine.findByLineText", query = "SELECT c FROM ChatLine c WHERE c.lineText = :lineText"),
    @NamedQuery(name = "ChatLine.findByCreatedAt", query = "SELECT c FROM ChatLine c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "ChatLine.findByBotResponse", query = "SELECT c FROM ChatLine c WHERE c.botResponse = :botResponse"),
    @NamedQuery(name = "ChatLine.findByUserId", query = "SELECT c FROM ChatLine c WHERE c.userId.id = :userId")})
public class ChatLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "line_text")
    private String lineText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "bot_response")
    private String botResponse;
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Chat chatId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChatUser userId;

    public ChatLine() {
    }

    public ChatLine(Long id) {
        this.id = id;
    }

    public ChatLine(Long id, String lineText, Date createdAt, String botResponse) {
        this.id = id;
        this.lineText = lineText;
        this.createdAt = createdAt;
        this.botResponse = botResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public Chat getChatId() {
        return chatId;
    }

    public void setChatId(Chat chatId) {
        this.chatId = chatId;
    }

    public ChatUser getUserId() {
        return userId;
    }

    public void setUserId(ChatUser userId) {
        this.userId = userId;
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
        if (!(object instanceof ChatLine)) {
            return false;
        }
        ChatLine other = (ChatLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airhacks.chatREST.ChatLine[ id=" + id + " ]";
    }

}
