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
public interface MarqueFacadeLocal {

    void create(Marque marque);

    void edit(Marque marque);

    void remove(Marque marque);

    Marque find(Object id);

    List<Marque> findAll();

    List<Marque> findRange(int[] range);

    int count();

    Boolean creationMarque(String nomMarque, String paysOrigine);
    
    public Boolean supprimerMarque(String nomMarque);

    void ajoutProduit(Produit produit, Marque marque);
    
    public List<Marque> listerTousMarque();

    
    
}
