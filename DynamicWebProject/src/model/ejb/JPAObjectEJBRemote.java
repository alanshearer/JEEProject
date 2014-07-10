package model.ejb;

import java.util.List;

import javax.ejb.Remote;

import model.JPAObject;

@Remote
public interface JPAObjectEJBRemote {
	public void persist(JPAObject jpaObject);

	public List<JPAObject> getAllList(String searchString);
	
	public void delete(Long jpaObjectId);
}
