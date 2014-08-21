package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompraDAO {
	
	protected EntityManager entityManager;
	
	public CompraDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Compra getById(long id){
		return entityManager.find(Compra.class, id);
	}
	
	public List<Compra> findAll(){
		return entityManager.createQuery("FROM " + Compra.class.getName()).getResultList();
	}
	
	public void persist(Compra p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Compra p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Compra p) {
        try {
            entityManager.getTransaction().begin();
            p = entityManager.find(Compra.class, p.getId());
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Compra p = getById(id);
            remove(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

