/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.boundary.jsf;

import de.hsos.kbse.controller.OrderRepository;
import de.hsos.kbse.controller.PizzaRepository;
import de.hsos.kbse.controller.UserRepository;
import de.hsos.kbse.entity.Pizza_Detail;
import de.hsos.kbse.entity.UserEntity;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Annika
 */
@Named(value ="order")
@ConversationScoped
public class OrderBoundary implements Serializable {
    
    
    @Inject
    private PizzaRepository repo;
    @Inject
    private Conversation conversation;
    @Inject
    private OrderRepository order;
    @Inject
    private UserRepository userRep;
    
    private UserEntity user;
    
    private boolean isSelfPickup;
    
    private List<Pizza_Detail> menuItems;
    
    private List<Pizza_Detail> itemsToBePurchased;
    private int gesamtpreis = 0;
    private int bestellnr;
    
    /**
     * Starte Coversation
     * Parsed self Pickup from URL
     */
    public void start() {
        menuItems = new ArrayList<>();
        user = new UserEntity();
        repo.getAllPizza().forEach(pizza -> {
            menuItems.add(new Pizza_Detail(pizza));
        });
        conversation.begin();
        String plz = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("plz");
        String s = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("self-pickup");
        isSelfPickup = Boolean.parseBoolean(s);
        user.setPlz(plz);
        bestellnr = (int)(10000.0 * Math.random());
    }
    
    public String abbort(){
        conversation.end();
        return "postcode?faces-redirect=true";
    }
    
    public String proceedToLogin(){
        itemsToBePurchased = menuItems.stream().filter(p -> p.getAnz() > 0).collect(Collectors.toList());
        if(this.checkoutTest()){
            return "UserData?faces-redirect=true";
        }
        return "error?faces-redirect=true";
    }

    public boolean checkoutTest(){
        if(itemsToBePurchased.isEmpty()){
            return false;
        }
        return true;
    }
    
    public void end() throws IOException {
        conversation.end();
        FacesContext.getCurrentInstance().getExternalContext().redirect("postcode.xhtml");
    }

    
    public String addUser(){
        this.userRep.addUser(user);
        return "checkout?faces-redirect=true";
    }
    
    public String placeOrder(){
        order.addOrder(user, itemsToBePurchased);        
        return "order_validation?faces-redirect=true";
    }
    

    public String netto(){
        Double temp =(double) this.brutto()/107;
        return String.format("%.2f", temp);
    }
    public int brutto(){
        itemsToBePurchased.forEach(element ->{
            gesamtpreis += (element.getAnz()*element.getPizza().getPrize());
        });
        int temp = gesamtpreis;
        gesamtpreis=0;
        return temp;
    }
    
    public String mwst(){
        Double temp = ((double) this.brutto()/100)-((double) this.brutto()/107);
        return String.format("%.2f",temp);
    }
    
    //GETTER/SETTER
    public boolean isIsSelfPickup() {
        return isSelfPickup;
    }

    public List<Pizza_Detail> getMenuItems() {
        return menuItems;
    }

    public List<Pizza_Detail> getItemsToBePurchased() {
        return itemsToBePurchased;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }
 
}
