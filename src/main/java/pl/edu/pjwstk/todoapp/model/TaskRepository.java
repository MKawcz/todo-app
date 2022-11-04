package pl.edu.pjwstk.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Override
    @RestResource(exported = false)
    default void deleteById(Long aLong) {
    }

    @Override
    @RestResource(exported = false)
    default void delete(Task entity) {
    }

    @RestResource(path = "done", rel = "done")
    List<Task> findByDone(@Param("state") boolean done);
}
