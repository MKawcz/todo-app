package pl.edu.pjwstk.todoapp.model;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAll();

    Optional<TaskGroup> findById(Long id);

    TaskGroup save(TaskGroup entity);
}
