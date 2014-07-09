package model.metamodel;

import java.sql.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import model.JPAObject;

@StaticMetamodel(JPAObject.class)
public class JPAObject_ {
	
	public static volatile SingularAttribute<JPAObject, Long> id;
	public static volatile SingularAttribute<JPAObject, String> name;
	public static volatile SingularAttribute<JPAObject, Date> signingDate;

}
