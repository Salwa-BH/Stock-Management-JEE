/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ElementDeStock implements Serializable{
    
    String refProduit;
    float quantite;

    public ElementDeStock(String refProduit, float quantite) {
        this.refProduit = refProduit;
        this.quantite = quantite;
    }

    public float getQuantite() {
        return quantite;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }
    
    
    
    
}
