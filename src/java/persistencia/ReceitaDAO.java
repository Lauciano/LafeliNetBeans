package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceitaDAO {
	
	protected EntityManager entityManager;
	
	public ReceitaDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Receita getById(long id){
		return entityManager.find(Receita.class, id);
	}
	
	public List<Receita> findAll(){
		return entityManager.createQuery("FROM " + Receita.class.getName()).getResultList();
	}
	
	public void persist(Receita p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Receita p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Receita p) {
        try {
            entityManager.getTransaction().begin();
            p = entityManager.find(Receita.class, p.getId());
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Receita p = getById(id);
            remove(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

