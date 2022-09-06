/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.entity;

import java.io.Serializable;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author Annika
 */
@Entity
@Vetoed
public class Pizza_Detail implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "modGener")
    @TableGenerator(name = "modGener", initialValue = 4)
    private Long id;
    
    private OrderEntity order;
    private Pizza pizza;
    private int anz;
    
    public Pizza_Detail(){}
    
    public Pizza_Detail(OrderEntity _order, Pizza _pizza, int _anz){
        this.order = _order;
        this.pizza = _pizza;
        this.anz = _anz;
    }
    
    public Pizza_Detail(Pizza _pizza){
        this.pizza = _pizza;
        this.anz = 0;
    }
    
    public void amountPlus(){
        anz++;
    }
    
    public void ammountMinus(){
        if(anz<=0){
            return;
        }
        anz--;
    }
    
    
    //Getter

    public OrderEntity getOrder() {
        return order;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getAnz() {
        return anz;
    }
    
    //SETTER

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setAnz(int anz) {
        this.anz = anz;
    }
    
}
