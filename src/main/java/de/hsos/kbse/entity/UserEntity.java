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
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Annika
 */
@Entity
@Vetoed
public class UserEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "userGen")
    @TableGenerator(name = "userGen", initialValue = 4)
    private Long id;
    
    @NotBlank
    private String vName;
    @NotBlank
    private String nName;
    @NotBlank
    private String telNr;
    @NotBlank
    private String str;
    @NotBlank
    private String hausNr;
    @NotBlank
    private String plz;
    @NotBlank
    private String ort;
    
    public UserEntity(){
        this.vName = "";
        this.nName = "";
        this.telNr = "";
        this.str = "";
        this.hausNr = "";
        this.plz = "";
        this.ort = "";
    }

    public UserEntity(String vName, String nName, String telNr, String str, String hausNr, String plz, String ort) {
        this.vName = vName;
        this.nName = nName;
        this.telNr = telNr;
        this.str = str;
        this.hausNr = hausNr;
        this.plz = plz;
        this.ort = ort;
    }
    
    public String addrToString(){
        return (this.vName + " " + this.nName + ", " + this.str + " " + this.hausNr + ", " + plz + " " + ort);
    }

    @Override
    public String toString() {
        return "User{" + "vorname=" + this.vName + ", nachname=" + this.nName + ", telefonnummer=" + this.telNr + ", strasse=" + this.str + ", hausnummer=" + this.hausNr + ", plz=" + this.plz + ", ort=" + this.ort + '}';
    }
    
    //GETTER

    public Long getId() {
        return id;
    }

    public String getvName() {
        return vName;
    }

    public String getnName() {
        return nName;
    }

    public String getTelNr() {
        return telNr;
    }

    public String getStr() {
        return str;
    }

    public String getHausNr() {
        return hausNr;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }
    
    //SETTER

    public void setId(Long id) {
        this.id = id;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    
}
