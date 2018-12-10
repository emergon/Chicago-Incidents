package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1IncidentType.class)
public abstract class P1IncidentType_ {

	public static volatile SingularAttribute<P1IncidentType, String> inciTypeName;
	public static volatile CollectionAttribute<P1IncidentType, P1Incidents> p1IncidentsCollection;
	public static volatile SingularAttribute<P1IncidentType, Short> inciTypeId;

}

