/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.controller;

import de.hsos.kbse.entity.Pizza;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Annika
 */
@Transactional
@RequestScoped
public class PizzaRepository {
    @PersistenceContext(name = "pizzaPU")
    private EntityManager em;
    
    
    public List<Pizza> getAllPizza() {
        return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
    }
    
    
}
