package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1RecentAction.class)
public abstract class P1RecentAction_ {

	public static volatile CollectionAttribute<P1RecentAction, P1Potholes> p1PotholesCollection;
	public static volatile SingularAttribute<P1RecentAction, Short> receActiId;
	public static volatile SingularAttribute<P1RecentAction, String> receActiName;
	public static volatile CollectionAttribute<P1RecentAction, P1Rodent> p1RodentCollection;
	public static volatile CollectionAttribute<P1RecentAction, P1GarbageCart> p1GarbageCartCollection;
	public static volatile CollectionAttribute<P1RecentAction, P1AbandonedVehicle> p1AbandonedVehicleCollection;

}

