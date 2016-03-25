package org.jboss.ejb3.examples.employeeregistry.ch09.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UseEntitySimpleEmployee {

	private EntityManagerFactory emf;
	private EntityManager em;

	 public static final long ID_DAVE = 1L;
	 public static final long ID_JOSH = 2L;
	 public static final long ID_RICK = 3L;
	 public static final String NAME_DAVE = "Dave";
	 public static final String NAME_DAVE_NEW = "Dave - The Good Doctor";
	 public static final String NAME_JOSH = "Josh";
	 public static final String NAME_RICK = "Rick, Jr.";

	 public static SimpleEmployee[] emps = new SimpleEmployee[] {
			new SimpleEmployee(ID_DAVE, NAME_DAVE),
			new SimpleEmployee(ID_JOSH, NAME_JOSH),
			new SimpleEmployee(ID_RICK, NAME_RICK) };

	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence
				.createEntityManagerFactory("tutorial-hibernate-mysql");
		em = emf.createEntityManager();

	}
	
	public void deleteAll(final Class<?> type) {
		getEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM " + type.getSimpleName() + " o").executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public SimpleEmployee getEmployee(long id) {	
		return em.find(SimpleEmployee.class, id);
	}
	
	public boolean isEmployee(SimpleEmployee emp) {
		return em.contains(emp);
	}

	public boolean insert() {
		boolean insert = false;
		getEntityManager();
		em.getTransaction().begin();

		for (SimpleEmployee emp : emps) {
			em.persist(emp);
		}

		em.getTransaction().commit();
		insert = checkManaged(emps);
		em.close();
		emf.close();
		
		return insert;
	}
	
	public boolean checkManaged(SimpleEmployee[] emps) {
		
		boolean ret = true;			
		for (SimpleEmployee emp : emps)
			if (! em.contains(emp)) {
				ret = false;
				break;
			}
					
		return ret;
	}
	
	public static void main(String[] args) {
		UseEntitySimpleEmployee use = new UseEntitySimpleEmployee();	
		use.deleteAll(SimpleEmployee.class);
		use.insert();
		
	}

}
