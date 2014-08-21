package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class VendaDAO {
	
	protected EntityManager entityManager;
	
	public VendaDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Venda getById(long id){
		return entityManager.find(Venda.class, id);
	}
	
	public List<Venda> findAll(){
		return entityManager.createQuery("FROM " + Venda.class.getName()).getResultList();
	}
	
	public void persist(Venda venda) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(venda);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Venda venda) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(venda);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Venda venda) {
        try {
            entityManager.getTransaction().begin();
            venda = entityManager.find(Venda.class, venda.getId());
            entityManager.remove(venda);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Venda pessoa = getById(id);
            remove(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}