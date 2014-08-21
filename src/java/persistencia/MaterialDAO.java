package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MaterialDAO {
	
	protected EntityManager entityManager;
	
	public MaterialDAO(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LafeliWeb");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public Material getById(long id){
		return entityManager.find(Material.class, id);
	}
	
	public List<Material> findAll(){
		return entityManager.createQuery("FROM " + Material.class.getName()).getResultList();
	}
	
	public void persist(Material material) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(material);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Material material) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(material);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Material material) {
        try {
            entityManager.getTransaction().begin();
            material = entityManager.find(Material.class, material.getId());
            entityManager.remove(material);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Material material = getById(id);
            remove(material);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

