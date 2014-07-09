package model;

import java.util.List;

public interface JPAObjectDAO {

	public void persist(JPAObject jpaObject);

	public List<JPAObject> getAllList();
}
