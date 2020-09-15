/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author DELL
 */
@Entity
public class Produit implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    private String referenceProduit;
    //private String referenceMarque;
    private String denomination;
    private Float prix;
    private Float poids;
    private Float volume;
    
    @ManyToOne
    public Marque MarqueProduit;

    public Produit() {
        this.referenceProduit = ""; //this.referenceMarque = "";
        this.denomination = "";
        this.prix = 0F;
        this.poids = 0F;
        this.volume = 0F;
        this.MarqueProduit= new Marque();
    }

    public Produit(String referenceProduit, String denomination, Float prix, Float poids, Float volume, Marque MarqueProduit) {
        this.referenceProduit = referenceProduit;
        this.denomination = denomination;
        this.prix = prix;
        this.poids = poids;
        this.volume = volume;
        this.MarqueProduit = MarqueProduit;
    }
    
    /*public Produit(String referenceProduit, String denomination, Float prix, Float poids, Float volume, String referenceMarque) {
        this.referenceProduit = referenceProduit;
        this.denomination = denomination;
        this.prix = prix;
        this.poids = poids;
        this.volume = volume;
        //this.referenceMarque = referenceMarque;
        this.MarqueProduit = MarqueProduit;
    }*/

 

    
    //Getters and Setters
    public String getReferenceProduit() {
        return referenceProduit;
    }
    public void setReferenceProduit(String referenceProduit) {
        this.referenceProduit = referenceProduit;
    }
    
    public String getDenomination() {
        return denomination;
    }
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
    
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    
    public Float getPoids() {
        return poids;
    }
    public void setPoids(Float poids) {
        this.poids = poids;
    }
    
     public Float getVolume() {
        return volume;
    }
    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Marque getMarqueProduit() {
        return MarqueProduit;
    }

    public void setMarqueProduit(Marque MarqueProduit) {
        this.MarqueProduit = MarqueProduit;
    }
    
    /*public String getReferenceMarque() {
        return referenceMarque;
    }

    public void setReferenceMarque(String referenceMarque) {
        this.referenceMarque = referenceMarque;
    }*/
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceProduit != null ? referenceProduit.hashCode() : 0);
        return hash;
    }

 

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.referenceProduit == null && other.referenceProduit != null) || (this.referenceProduit != null && !this.referenceProduit.equals(other.referenceProduit))) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "Reference de produit: "+referenceProduit+", marque: "+MarqueProduit.getnomMarque()+", denomination: "+denomination+", prix: "+prix+", poids: "+poids+", volume: "+volume;
    }
}
