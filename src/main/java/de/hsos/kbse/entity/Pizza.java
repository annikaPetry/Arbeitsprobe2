/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.entity;

import java.io.Serializable;
import java.util.Objects;
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
public class Pizza implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "modGen")
    @TableGenerator(name = "modGen", initialValue = 4)
    private Long id;
    private String name;
    
    // Prize is saved in cents
    // 4,50  is in DB => 450
    private Integer prize;
    
    private String imageURL;
    private String description;


    public Pizza() {
    }

    public Pizza(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        if (this.id != null) {
            int hash = 7;
            hash = 89 * hash + Objects.hashCode(this.id);
            return hash;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.id == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pizza other = (Pizza) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", name=" + name + '}';
    }
}

