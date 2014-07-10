package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
public class JPAObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3680312739760840337L;

	@Id @GeneratedValue
	Long id;
	
	@NotNull @Size(min=3, max=20)
	private String name;
	private Date signingDate;
	
	public JPAObject(){
	}
	
	public JPAObject(String name){
		this.name = name;
		this.signingDate = new Date(System.currentTimeMillis());
	}

	@Override
	public String toString(){
		return name + " (signed on " + signingDate +")";
	}
	
	public Long getId(){
		return this.id;
	}
	
}
