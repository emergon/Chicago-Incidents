package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1Status.class)
public abstract class P1Status_ {

	public static volatile SingularAttribute<P1Status, Short> statId;
	public static volatile SingularAttribute<P1Status, String> statName;
	public static volatile CollectionAttribute<P1Status, P1Incidents> p1IncidentsCollection;

}

