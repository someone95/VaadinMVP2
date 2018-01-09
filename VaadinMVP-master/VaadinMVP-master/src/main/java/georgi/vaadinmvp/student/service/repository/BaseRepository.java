package georgi.vaadinmvp.student.service.repository;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

//@Transactional
public abstract class BaseRepository<ENTITY extends HasId> implements CrudRepository<ENTITY>{


    private  Class<ENTITY> clazz;

    protected EntityManager entityManager;

    public BaseRepository(Class<ENTITY> clazz){
        this.clazz = clazz;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-demo");
        this.entityManager = factory.createEntityManager();
    }


    public long create(ENTITY e) {
    	entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        return e.getId();
    }

    public List<ENTITY> findAll(){
        CriteriaQuery<ENTITY> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(clazz);
        Root<ENTITY> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        TypedQuery<ENTITY> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
    public ENTITY findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update(ENTITY e) {
        entityManager.merge(e);
    }

    public void delete(long id) {
    	entityManager.getTransaction().begin();
    	ENTITY item = findById(id);
        entityManager.remove(item);
        entityManager.getTransaction().commit();
    }
}
