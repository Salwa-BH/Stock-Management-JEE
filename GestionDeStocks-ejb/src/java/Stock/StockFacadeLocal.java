/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stock;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DELL
 */
@Local
public interface StockFacadeLocal {

    void create(Stock stock);

    void edit(Stock stock);

    void remove(Stock stock);

    Stock find(Object id);

    List<Stock> findAll();

    List<Stock> findRange(int[] range);

    int count();

    Boolean addEntreeStock(String nomStock, String refProduit, float quantite);

    Boolean createStock(String nomStock);
    
    //public Stock returnStock(String nomStock);
    
    public Boolean removeSortieStock(String nomStock, String refProduit);
    
    public Boolean removeStock(String nomStock);
    
    Boolean modifierQntStock(String nomStock,String refProduit, float quantite);
    
    public List<Stock> listerTousStocks();
    
    public ListeDeStock listerUnStock(String nomStock);
    
}
