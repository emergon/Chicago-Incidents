package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1Color.class)
public abstract class P1Color_ {

	public static volatile SingularAttribute<P1Color, Short> coloId;
	public static volatile CollectionAttribute<P1Color, P1AbandonedVehicle> p1AbandonedVehicleCollection;
	public static volatile SingularAttribute<P1Color, String> coloName;

}

