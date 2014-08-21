package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecimentoDAO {
	
	protected EntityManager entityManager;
	
	public FornecimentoDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Fornecimento getById(long id){
		return entityManager.find(Fornecimento.class, id);
	}
	
	public List<Fornecimento> findAll(){
		return entityManager.createQuery("FROM " + Fornecimento.class.getName()).getResultList();
	}
	
	public void persist(Fornecimento fornecimento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecimento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Fornecimento fornecimento) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(fornecimento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Fornecimento fornecimento) {
        try {
            entityManager.getTransaction().begin();
            fornecimento = entityManager.find(Fornecimento.class, fornecimento.getId());
            entityManager.remove(fornecimento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Fornecimento fornecimento = getById(id);
            remove(fornecimento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

