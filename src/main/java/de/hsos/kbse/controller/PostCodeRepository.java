/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.controller;

import de.hsos.kbse.entity.PostCode;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Annika
 */
@Transactional
@RequestScoped
public class PostCodeRepository {
    
    @PersistenceContext(name = "pizzaPU")
    private EntityManager em;
    
    public boolean findByPostCode(String postcode) {
        // EnitityManager will throw an error when no Result is found
        try{
            em.createQuery("SELECT p "
                + "FROM PostCode p "
                + "WHERE p.zipcode = :postcode ", PostCode.class).setParameter("postcode", postcode).getSingleResult();
        }catch(NoResultException ex) {
            System.out.println("NO RESULT");
            return false;
        }
        // No Exception = Result Found
        // Delivery can take place
        System.out.println("RESULT");
        return true;
    }
    
}
