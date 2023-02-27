package pl.edu.pjwstk.todoapp.reports;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersistedTaskEventRepository extends JpaRepository<PersistedTaskEvent, Long> {
    List<PersistedTaskEvent> findByTaskId(long taskId);
}
