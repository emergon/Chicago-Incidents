package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1CurrentActivity.class)
public abstract class P1CurrentActivity_ {

	public static volatile CollectionAttribute<P1CurrentActivity, P1Potholes> p1PotholesCollection;
	public static volatile CollectionAttribute<P1CurrentActivity, P1Rodent> p1RodentCollection;
	public static volatile CollectionAttribute<P1CurrentActivity, P1GarbageCart> p1GarbageCartCollection;
	public static volatile CollectionAttribute<P1CurrentActivity, P1AbandonedVehicle> p1AbandonedVehicleCollection;
	public static volatile SingularAttribute<P1CurrentActivity, Short> currActiId;
	public static volatile SingularAttribute<P1CurrentActivity, String> currActiName;

}

