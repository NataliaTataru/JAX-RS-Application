/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.chatREST.service;

import com.airhacks.chatREST.ChatLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.json.JSONObject;

/**
 *
 * @author nataliat
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public List<T> findByUserId(int userId) {
        javax.persistence.Query q = getEntityManager().createNamedQuery("ChatLine.findByUserId");
        q.setParameter("userId", userId);
        return q.getResultList();
    }

    public void insertConversationNativeGET(JSONObject conversation) {

        System.out.println("************************************INSERTING");
        String query = "INSERT INTO chat_line (chat_id, user_id, line_text, created_at, bot_response) values (?,?,?,?,?)";
//        System.out.println(conversation.getId());
//        System.out.println(conversation.getCreatedAt());
//        System.out.println(conversation.toString());
//        System.out.println(conversation.getUserId());
//        System.out.println(conversation.getLineText());
//        System.out.println(conversation.getBotResponse());
        

        Long userId = (long) 1;
        Long chatId = (long) 1;
        Query q = getEntityManager().createNativeQuery(query);
        q.setParameter(1, ((Integer)conversation.get("chatId")).longValue());
        q.setParameter(2, ((Integer)conversation.get("userId")).longValue());
        q.setParameter(3, conversation.get("lineText"));
        q.setParameter(4, conversation.get("createdAt"));
        q.setParameter(5, conversation.get("botResponse"));
        q.executeUpdate();

    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
