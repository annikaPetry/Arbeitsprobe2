/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.controller;

import de.hsos.kbse.entity.OrderEntity;
import de.hsos.kbse.entity.Pizza_Detail;
import de.hsos.kbse.entity.UserEntity;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

/**
 *
 * @author Annika
 */
@Transactional
@RequestScoped
public class OrderRepository {
    
    @PersistenceContext(name = "pizzaPU")
    private EntityManager em;
    
    public List<Pizza_Detail> getAllPizzaOrdered (OrderEntity order){
        try{
            return em.createQuery("SELECT p FROM Pizza_Detail AS p WHERE p.order =: order", Pizza_Detail.class).setParameter("order",order.getId()).getResultList();
        }
        catch(NoResultException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void addOrder (UserEntity user, List<Pizza_Detail> pizzen){
        OrderEntity order = new OrderEntity(user, pizzen);
        pizzen.forEach(p -> {
            p.setOrder(order);
        });
        try{
            em.persist(order);
        }
        catch(PersistenceException ex){
            ex.printStackTrace();
        }
    }
}
