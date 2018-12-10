package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(P1Xrhsths.class)
public abstract class P1Xrhsths_ {

	public static volatile SingularAttribute<P1Xrhsths, Short> xrhsKwd;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsFname;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsLname;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsAddress;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsPassword;
	public static volatile CollectionAttribute<P1Xrhsths, P1XrhsthAction> p1XrhsthActionCollection;
	public static volatile SingularAttribute<P1Xrhsths, Short> xrhsType;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsEmail;
	public static volatile CollectionAttribute<P1Xrhsths, P1Incidents> p1IncidentsCollection;
	public static volatile SingularAttribute<P1Xrhsths, String> xrhsUsername;

}

