package pl.edu.pjwstk.todoapp.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.todoapp.model.event.TaskDone;
import pl.edu.pjwstk.todoapp.model.event.TaskEvent;
import pl.edu.pjwstk.todoapp.model.event.TaskUndone;

@Service
public class ChangedTaskEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ChangedTaskEventListener.class);

    private final PersistedTaskEventRepository repository;

    public ChangedTaskEventListener(PersistedTaskEventRepository repository) {
        this.repository = repository;
    }

    @Async
    @EventListener
    public void on(TaskDone event){
        onChanged(event);
    }

    @Async
    @EventListener
    public void on(TaskUndone event){
        onChanged(event);
    }

    private void onChanged(TaskEvent event) {
        logger.info("Got " + event);
        repository.save(new PersistedTaskEvent(event));
    }
}
