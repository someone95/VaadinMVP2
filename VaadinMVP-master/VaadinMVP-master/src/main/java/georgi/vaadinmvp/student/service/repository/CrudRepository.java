package georgi.vaadinmvp.student.service.repository;

import java.util.Collection;
import java.util.List;

public interface CrudRepository<ENTITY extends HasId> {

    long create(ENTITY e);

    ENTITY findById(long id);

    void update(ENTITY e);

    void delete(long id);

    List<ENTITY> findAll();
}
