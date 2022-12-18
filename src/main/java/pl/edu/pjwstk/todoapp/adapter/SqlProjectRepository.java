package pl.edu.pjwstk.todoapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.todoapp.model.Project;
import pl.edu.pjwstk.todoapp.model.ProjectRepository;
import pl.edu.pjwstk.todoapp.model.TaskGroup;
import pl.edu.pjwstk.todoapp.model.TaskGroupRepository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {
    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}
