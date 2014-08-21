package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO {
	
	protected EntityManager entityManager;
	
	public ProdutoDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Produto getById(long id){
		return entityManager.find(Produto.class, id);
	}
	
	public List<Produto> findAll(){
		return entityManager.createQuery("FROM " + Produto.class.getName()).getResultList();
	}
	
	public void persist(Produto p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Produto p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Produto p) {
        try {
            entityManager.getTransaction().begin();
            p = entityManager.find(Produto.class, p.getId());
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Produto p = getById(id);
            remove(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

