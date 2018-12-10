package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1AbandonedVehicle.class)
public abstract class P1AbandonedVehicle_ {

	public static volatile SingularAttribute<P1AbandonedVehicle, P1CurrentActivity> abanVehiActivity;
	public static volatile SingularAttribute<P1AbandonedVehicle, Short> abanVehiSsa;
	public static volatile SingularAttribute<P1AbandonedVehicle, P1RecentAction> abanVehiRecentAction;
	public static volatile SingularAttribute<P1AbandonedVehicle, String> abanVehiPlate;
	public static volatile SingularAttribute<P1AbandonedVehicle, P1Incidents> inciKwd;
	public static volatile SingularAttribute<P1AbandonedVehicle, String> abanVehiModel;
	public static volatile SingularAttribute<P1AbandonedVehicle, Integer> abanVehiId;
	public static volatile SingularAttribute<P1AbandonedVehicle, Integer> abanVehiDaysParked;
	public static volatile SingularAttribute<P1AbandonedVehicle, P1Color> abanVehiColor;

}

