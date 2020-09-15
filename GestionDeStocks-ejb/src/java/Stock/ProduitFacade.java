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
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "GestionDeStocks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    @Override
    public Boolean creationProduit_marque(String referenceProduit, String denomination, Float prix, Float poids, Float volume, Marque MarqueProduit) {
        Produit p = (Produit) em.find(Produit.class,referenceProduit);
        Marque m = (Marque) em.find(Marque.class,MarqueProduit.getnomMarque());
        if(m!=null){
            if(p==null){
                p = new Produit(referenceProduit,denomination,  prix,  poids, volume, MarqueProduit);
                m.addProduit(p);
                em.persist(m);
                em.persist(p);
            }
            else{
                return(false);
            }
        }
        else
            return(false);
        return(true);
    }
    
    /*@Override
    public Boolean creationProduit_ref(String referenceProduit, String denomination, Float prix, Float poids, Float volume, String MarqueProduit) {
        Produit p = (Produit) em.find(Produit.class,referenceProduit);
        Marque m = (Marque) em.find(Marque.class,MarqueProduit);
        if(m!=null){
            if(p==null){
                p = new Produit(referenceProduit,denomination,  prix,  poids, volume, MarqueProduit);
                em.persist(p);
            }
            else{
                return(false);
            }
        }
        else
            return(false);
        return(true);
    }*/
    
    @Override
    public Marque findMarqueFromRef(String ref){
        Marque m = (Marque) em.find(Marque.class,ref);
        return m;
    }
    
    @Override
    public Boolean supprimerProduit(String referenceProduit){
        Produit p = (Produit) em.find(Produit.class,referenceProduit);
        if (p!= null){
            em.remove(p);
            return(true);
        }
        return(false);
    }
    
    @Override
    public Boolean modifierProduit(String ref, String denomination, Float prix, Float poids, Float volume, Marque marque) {
        Produit P = (Produit) em.find(Produit.class,ref);
        if(P==null)
        {
            return false; 
        }
        else 
        {
            P.setDenomination(denomination);
            P.setPoids(poids);
            P.setPrix(prix);
            P.setVolume(volume);
            P.setMarqueProduit(marque);
        }
        return true;
    }
    
    @Override
    public List<Produit> listerProduitMarque(String nomMarque) {
        Marque m = (Marque) em.find(Marque.class, nomMarque);
        if(m != null){
            return(m.getListeDesProduits());
        }
        return(null);
    }
    
    @Override
    public List<Produit> listerTousProduit(){
        return (List<Produit>) findAll();
    }
            
    
    
    
}
