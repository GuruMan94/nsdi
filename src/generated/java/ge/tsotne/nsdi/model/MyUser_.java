package ge.tsotne.nsdi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MyUser.class)
public abstract class MyUser_ {

	public static volatile SingularAttribute<MyUser, String> password;
	public static volatile SingularAttribute<MyUser, Boolean> active;
	public static volatile SingularAttribute<MyUser, Long> id;
	public static volatile SingularAttribute<MyUser, String> username;

	public static final String PASSWORD = "password";
	public static final String ACTIVE = "active";
	public static final String ID = "id";
	public static final String USERNAME = "username";

}

