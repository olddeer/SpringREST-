package at.bitmedia.schoolreader.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomizedSaveImpl<Task> implements CustomizedSave<Task> {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public <S extends Task> S save(S entity) {
        // do your logic here
            entityManager.persist(entity);
            return entity;
    }
}
