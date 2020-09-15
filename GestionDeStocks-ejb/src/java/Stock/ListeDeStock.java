/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ListeDeStock implements Serializable{
    
    List<ElementDeStock> listeDeStock;

    public ListeDeStock(List<ElementDeStock> listeDeStock) {
        this.listeDeStock = listeDeStock;
    }
    
    public ListeDeStock() {
        this.listeDeStock = new ArrayList<>();
    }

    public List<ElementDeStock> getListeDeStock() {
        return listeDeStock;
    }

    public void setListeDeStock(List<ElementDeStock> listeDeStock) {
        this.listeDeStock = listeDeStock;
    }
    
    public void addStock(String refProduit, float quantite){
        ElementDeStock e = new ElementDeStock(refProduit,quantite);
        listeDeStock.add(e);
    }
    
    public Boolean findRefProduit(String refProduit){
        for(int i=0; i<listeDeStock.size(); i++){
            if(listeDeStock.get(i).getRefProduit().equals(refProduit))
                return true;
        }
        return false;
        
    }
    
    public void removeStock(String refProduit){
        for(int i=0;i< listeDeStock.size();i++){
            if(listeDeStock.get(i).getRefProduit().equals(refProduit)){
                listeDeStock.remove(i);
                break;
            }
        }
    }
            
    
}
