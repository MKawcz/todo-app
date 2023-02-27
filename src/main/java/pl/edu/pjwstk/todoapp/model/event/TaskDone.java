package pl.edu.pjwstk.todoapp.model.event;

import pl.edu.pjwstk.todoapp.model.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
    TaskDone(final Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
