package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecedorDAO {
	
	protected EntityManager entityManager;
	
	public FornecedorDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Fornecedor getById(int id){
		return entityManager.find(Fornecedor.class, id);
	}
	
	public List<Fornecedor> findAll(){
		return entityManager.createQuery("FROM " + Fornecedor.class.getName()).getResultList();
	}
	
	public void persist(Fornecedor fornecedor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Fornecedor fornecedor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Fornecedor fornecedor) {
        try {
            entityManager.getTransaction().begin();
            fornecedor = entityManager.find(Fornecedor.class, fornecedor.getId());
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(int id) {
        try {
        	Fornecedor fornecedor = getById(id);
            remove(fornecedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

