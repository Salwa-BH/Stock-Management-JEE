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
public class MarqueFacade extends AbstractFacade<Marque> implements MarqueFacadeLocal {

    @PersistenceContext(unitName = "GestionDeStocks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarqueFacade() {
        super(Marque.class);
    }

    @Override
    public Boolean creationMarque(String nomMarque, String paysOrigine) {
        Marque m = (Marque) em.find(Marque.class,nomMarque);
        if(m==null){
            m = new Marque(nomMarque, paysOrigine);
            em.persist(m);
        }
        else{
            return(false);
        }
        return(true);
    }
    
    @Override
    public Boolean supprimerMarque(String nomMarque){
        Marque m = (Marque) em.find(Marque.class, nomMarque);
        if (m!= null){
            em.remove(m);
            return(true);
        }
        return(false);
    }

    @Override
    public void ajoutProduit(Produit produit, Marque marque) {
        marque.addProduit(produit);
        em.merge(marque);
    }

    @Override
    public List<Marque> listerTousMarque() {
        return (List<Marque>) findAll();
    }
}
