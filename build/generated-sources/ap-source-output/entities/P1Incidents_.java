package entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1Incidents.class)
public abstract class P1Incidents_ {

	public static volatile CollectionAttribute<P1Incidents, P1Graffiti> p1GraffitiCollection;
	public static volatile SingularAttribute<P1Incidents, Date> inciCompletionDate;
	public static volatile SingularAttribute<P1Incidents, BigDecimal> inciLatitude;
	public static volatile SingularAttribute<P1Incidents, Short> inciWard;
	public static volatile CollectionAttribute<P1Incidents, P1StreetLightsOne> p1StreetLightsOneCollection;
	public static volatile SingularAttribute<P1Incidents, P1Xrhsths> xrhsKwd;
	public static volatile SingularAttribute<P1Incidents, String> inciZip;
	public static volatile SingularAttribute<P1Incidents, P1IncidentType> inciRequestType;
	public static volatile SingularAttribute<P1Incidents, BigDecimal> inciY;
	public static volatile SingularAttribute<P1Incidents, BigDecimal> inciX;
	public static volatile SingularAttribute<P1Incidents, String> inciAddress;
	public static volatile CollectionAttribute<P1Incidents, P1TreeDebris> p1TreeDebrisCollection;
	public static volatile CollectionAttribute<P1Incidents, P1Sanitation> p1SanitationCollection;
	public static volatile SingularAttribute<P1Incidents, Short> inciCommArea;
	public static volatile SingularAttribute<P1Incidents, BigDecimal> inciLongitude;
	public static volatile SingularAttribute<P1Incidents, P1Status> inciStatus;
	public static volatile SingularAttribute<P1Incidents, Short> inciPoliceDistrict;
	public static volatile CollectionAttribute<P1Incidents, P1Rodent> p1RodentCollection;
	public static volatile CollectionAttribute<P1Incidents, P1GarbageCart> p1GarbageCartCollection;
	public static volatile SingularAttribute<P1Incidents, Integer> inciKwd;
	public static volatile CollectionAttribute<P1Incidents, P1TreeTrims> p1TreeTrimsCollection;
	public static volatile SingularAttribute<P1Incidents, String> inciRequestNum;
	public static volatile SingularAttribute<P1Incidents, Date> inciCreationDate;
	public static volatile CollectionAttribute<P1Incidents, P1Potholes> p1PotholesCollection;
	public static volatile CollectionAttribute<P1Incidents, P1AbandonedVehicle> p1AbandonedVehicleCollection;
	public static volatile CollectionAttribute<P1Incidents, P1AlleyLightsOut> p1AlleyLightsOutCollection;
	public static volatile CollectionAttribute<P1Incidents, P1StreetLightsAll> p1StreetLightsAllCollection;

}

