/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "GestionDeStocks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }

    @Override
    public Boolean addEntreeStock(String nomStock, String refProduit, float quantite) {
        Stock s = em.find(Stock.class, nomStock);
        if(s != null){
           if(s.getL().findRefProduit(refProduit)==false){
                s.addStock(refProduit, quantite);
                em.merge(s);
                return(true);
           }
            else
                return false;
                    
        }
        else{
            return(false);
        }
    }
           
           

    @Override
    public Boolean createStock(String nomStock) {
        Stock s = (Stock) em.find(Stock.class,nomStock);
        if(s==null){
            s = new Stock(nomStock);
            em.persist(s);
        }
        else{
            return(false);
        }
        return(true);
    }
    
    /*@Override
    public Stock returnStock(String nomStock) {
        Stock s = (Stock) em.find(Stock.class,nomStock);
            return s; 
    }*/
    
    public Boolean removeSortieStock(String nomStock, String refProduit) {
        Stock s = em.find(Stock.class, nomStock);
        if(s != null){
            if(s.getL().findRefProduit(refProduit)){
                s.removeProductFromStock(refProduit);
                em.merge(s);
                return true;
            }
            else
                return false;
        }
        return false;
    }
    
    @Override
    public Boolean removeStock(String nomStock) {
        Stock s = em.find(Stock.class, nomStock);
        if(s != null){
            em.remove(s);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean modifierQntStock(String nomStock,String refProduit, float quantite){
        Stock s = em.find(Stock.class, nomStock);
        if(s != null){
            for(int i=0; i<s.getL().getListeDeStock().size(); i++){
                if(s.getL().getListeDeStock().get(i).getRefProduit().equals(refProduit)){
                    s.getL().getListeDeStock().get(i).setQuantite(quantite);
                    em.merge(s);
                    return true;
                }
            }
        }
        
        return(false);    
    }
    
    @Override
    public List<Stock> listerTousStocks(){
        return (List<Stock>) findAll();
    }
    
    @Override
    public ListeDeStock listerUnStock(String nomStock){
        Stock s = em.find(Stock.class, nomStock);
        return s.getL();
    }
    
    
}
