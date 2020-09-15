package Stock;

import Stock.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-23T23:02:52")
@StaticMetamodel(Marque.class)
public class Marque_ { 

    public static volatile ListAttribute<Marque, Produit> ListeDesProduits;
    public static volatile SingularAttribute<Marque, String> paysOrigine;
    public static volatile SingularAttribute<Marque, String> nomMarque;

}