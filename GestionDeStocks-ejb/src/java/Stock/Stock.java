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

/**
 *
 * @author DELL
 */
@Entity
public class Stock implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String nomStock;
    private ListeDeStock l;

    public Stock() {
    }
    
    

    public Stock(String nomStock) {
        this.nomStock = nomStock;
        this.l=new ListeDeStock();
    }
    
    

    public ListeDeStock getL() {
        return l;
    }

    public void setL(ListeDeStock l) {
        this.l = l;
    }

    public Stock(String nomStock, ListeDeStock l) {
        this.nomStock = nomStock;
        this.l = l;
    }
    
    public void addStock(String refProduit, float quantite){
        this.l.addStock(refProduit, quantite);
    }

    public String getNomStock() {
        return nomStock;
    }

    public void setNomStock(String nomStock) {
        this.nomStock = nomStock;
    }

    public void removeProductFromStock(String refProduit){
        this.l.removeStock(refProduit);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomStock != null ? nomStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.nomStock == null && other.nomStock != null) || (this.nomStock != null && !this.nomStock.equals(other.nomStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stock.Stock[ id=" + nomStock + " ]";
    }
    
}
