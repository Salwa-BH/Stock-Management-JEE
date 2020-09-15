/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author DELL
 */
@Entity
public class Marque implements Serializable {

    //private static final long serialVersionUID = 1L;
     //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id 
    private String nomMarque;
    private String paysOrigine;
    @OneToMany
    public List<Produit> ListeDesProduits=new ArrayList<>(); 
    
    public Marque(){
        this.nomMarque = "";
        this.paysOrigine = "";
    }
    public Marque(String nomMarque, String paysOrigine){
        this.nomMarque = nomMarque;
        this.paysOrigine = paysOrigine;
    }
    
    public void addProduit(Produit p){
        ListeDesProduits.add(p);
    }
    public String showrefProduit(Produit p){
        StringBuffer r = new StringBuffer();
        for(int i=0; i<ListeDesProduits.size(); i++){
            r.append(ListeDesProduits.get(i));
            r.append(", ");
        }
        return r.toString();
    }
    
    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }


    public String getnomMarque() {
        return nomMarque;
    }

    public void setnomMarque(String id) {
        this.nomMarque = id;
    }

    public List<Produit> getListeDesProduits() {
        return ListeDesProduits;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomMarque != null ? nomMarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.nomMarque== null && other.nomMarque != null) || (this.nomMarque != null && !this.nomMarque.equals(other.nomMarque))) {
            return false;
        }
        return true;
    }

    @Override
   public String toString() {
        StringBuffer r = new StringBuffer("Le produit de marque " + nomMarque + ", de pays d'origine " + paysOrigine + ", et de liste de reference '");
        for(int i=0; i<ListeDesProduits.size(); i++){
            r.append(ListeDesProduits.get(i));
            r.append(", ");
        }
        r.append("'");
        return r.toString();
    }
    
}
