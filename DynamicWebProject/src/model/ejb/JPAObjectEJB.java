package model.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import com.sun.mail.imap.protocol.SearchSequence;

import model.JPAObject;
import model.metamodel.JPAObject_;

/**
 * Session Bean implementation class JPAObjectEJB
 */
@Stateless(mappedName = "JPAObjectEJB")
@LocalBean
public class JPAObjectEJB implements JPAObjectEJBRemote {

    /**
     * Default constructor. 
     */
    public JPAObjectEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext private EntityManager em; 
	
  	public void persist(JPAObject jpaObject){
  		em.persist(jpaObject);
  	}

  	public List<JPAObject> getAllList(String searchString){

//  		List<JPAObject> list = new ArrayList<JPAObject>();
//  		list.add(new JPAObject("pippO"));
//  		list.add(new JPAObject("pluto"));
//  		
//  		return list;
  		String jolly = "%";
  		searchString = jolly + searchString + jolly;
  		CriteriaBuilder cb = em.getCriteriaBuilder();
  		CriteriaQuery<JPAObject> cq = cb.createQuery(JPAObject.class);
  		Root<JPAObject> r = cq.from(JPAObject.class);
  		Predicate predicate = cb.like(r.<String>get("name"), searchString);
  		CriteriaQuery<JPAObject> all = cq.select(r).where(predicate);
  		TypedQuery<JPAObject> query = em.createQuery(all);
  		return query.getResultList();
  	}
  	
	public void delete(Long jpaObjectId){
		JPAObject objectToDelete = em.find(JPAObject.class, jpaObjectId);
		 
		  em.remove(objectToDelete);
	}
	

}
