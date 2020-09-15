package Stock;

import Stock.Marque;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-23T23:02:52")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> referenceProduit;
    public static volatile SingularAttribute<Produit, Float> volume;
    public static volatile SingularAttribute<Produit, Float> prix;
    public static volatile SingularAttribute<Produit, Float> poids;
    public static volatile SingularAttribute<Produit, Marque> MarqueProduit;
    public static volatile SingularAttribute<Produit, String> denomination;

}