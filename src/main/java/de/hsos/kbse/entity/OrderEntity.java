/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.enterprise.inject.Vetoed;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

/**
 *
 * @author Annika
 */
@Entity
@Vetoed
public class OrderEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "modGenerate")
    @TableGenerator(name = "modGenerate", initialValue = 4)
    private Long id;
    
    
    private UserEntity user;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pizza_Detail> pizzen;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, List<Pizza_Detail> pizzen) {
        this.user = user;
        this.pizzen = pizzen;
    }
    
    
    //GETTER
    public Long getId() {    
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public List<Pizza_Detail> getPizzen() {
        return pizzen;
    }
    
    //SETTER
    public void setId(Long id) {    
        this.id = id;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setPizzen(List<Pizza_Detail> pizzen) {
        this.pizzen = pizzen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.user);
        hash = 23 * hash + Objects.hashCode(this.pizzen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderEntity other = (OrderEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
