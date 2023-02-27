package pl.edu.pjwstk.todoapp.model.event;

import pl.edu.pjwstk.todoapp.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
    TaskUndone(final Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
