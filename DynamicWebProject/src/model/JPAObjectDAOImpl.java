package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import model.metamodel.JPAObject_;


@Stateless
public class JPAObjectDAOImpl implements JPAObjectDAO{
	
	@PersistenceContext private EntityManager em; 
	
	public void persist(JPAObject jpaObject){
		em.persist(jpaObject);
	}

	public List<JPAObject> getAllList(){

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<JPAObject> cq = cb.createQuery(JPAObject.class);
		Root<JPAObject> r = cq.from(JPAObject.class);
		//Predicate predicate = cb.like(r.get(JPAObject_.name), name);
		CriteriaQuery<JPAObject> all = cq.select(r).orderBy(cb.asc(r.get(JPAObject_.id)));
		TypedQuery<JPAObject> query = em.createQuery(all);
		return query.getResultList();
	}
	
}
