/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.controller;

import de.hsos.kbse.entity.UserEntity;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

/**
 *
 * @author Annika
 */
@Transactional
@RequestScoped
public class UserRepository {
    
    @PersistenceContext(name = "pizzaPU")
    private EntityManager em;
    
    public void addUser(UserEntity user){
       try{
        em.persist(user);
       }
       catch(PersistenceException ex){
           ex.printStackTrace();
       }
    }
    
}
