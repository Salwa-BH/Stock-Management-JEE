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
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();
    
    public Boolean creationProduit_marque(String referenceProduit, String denomination, Float prix, Float poids, Float volume, Marque MarqueProduit);
    
    //public Boolean creationProduit_ref(String referenceProduit, String denomination, Float prix, Float poids, Float volume, String MarqueProduit);
            
    public Marque findMarqueFromRef(String ref);
    
    public Boolean supprimerProduit(String referenceProduit);
    
    public Boolean modifierProduit(String ref, String denomination, Float prix, Float poids, Float volume, Marque marque);
    
    public List<Produit> listerTousProduit();
    
    public List<Produit> listerProduitMarque(String nomMarque);
}
