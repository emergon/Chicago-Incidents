package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1GarbageCart.class)
public abstract class P1GarbageCart_ {

	public static volatile SingularAttribute<P1GarbageCart, Integer> garbCartId;
	public static volatile SingularAttribute<P1GarbageCart, P1RecentAction> garbCartRecentAction;
	public static volatile SingularAttribute<P1GarbageCart, Integer> garbCartDelivered;
	public static volatile SingularAttribute<P1GarbageCart, P1Incidents> inciKwd;
	public static volatile SingularAttribute<P1GarbageCart, P1CurrentActivity> garbCartActivity;
	public static volatile SingularAttribute<P1GarbageCart, Short> garbCartSsa;

}

