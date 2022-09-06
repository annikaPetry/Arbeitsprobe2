/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.boundary.jsf;

import de.hsos.kbse.controller.PostCodeRepository;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Annika
 */
@RequestScoped
@Named(value="postcode")
public class PostCodeBoundary implements Serializable{
    
    @Inject
    PostCodeRepository  repo;
    
    private boolean showNoDeliveryHint = false;
    
    private String postCodeValue = "Deine Postleitzahl";
    
    
    
    public boolean checkForDeleviry() throws IOException {
        System.out.println("CHECK");
        if(repo.findByPostCode(this.postCodeValue)) {
            showNoDeliveryHint = false;
            //Redirect to next Page
            FacesContext.getCurrentInstance().getExternalContext().redirect("order.xhtml?self-pickup=false&plz="+postCodeValue);
        }
        else {
            showNoDeliveryHint = true;
            
        }
        return showNoDeliveryHint;
    }
    
    public void redirectToOrder() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("order.xhtml?self-pickup=true&plz="+postCodeValue);
    }
    

//GETTER/SETTER
    public boolean isShowNoDeliveryHint() {
        return showNoDeliveryHint;
    }

    public String getPostCodeValue() {
        return postCodeValue;
    }

    public void setPostCodeValue(String postCodeValue) {
        this.postCodeValue = postCodeValue;
    }
    
    
}
