package pl.edu.pjwstk.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.todoapp.logic.TaskGroupService;
import pl.edu.pjwstk.todoapp.model.Task;
import pl.edu.pjwstk.todoapp.model.TaskRepository;
import pl.edu.pjwstk.todoapp.model.projection.GroupReadModel;
import pl.edu.pjwstk.todoapp.model.projection.GroupWriteModel;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class TaskGroupController {
    public static final Logger logger = LoggerFactory.getLogger(TaskGroupController.class);
    private final TaskRepository repository;
    private final TaskGroupService service;

    public TaskGroupController(final TaskRepository repository, TaskGroupService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GroupReadModel> createGroup(@RequestBody @Valid GroupWriteModel toCreate) {
        GroupReadModel result = service.createGroup(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    public ResponseEntity<List<GroupReadModel>> readAllGroups(){
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping ("/{id}")
    ResponseEntity<List<Task>> readAllTasksFromGroup(@PathVariable long id) {
        return ResponseEntity.ok(repository.findAllByGroup_Id(id));
    }

    @Transactional
    @PatchMapping ("/{id}")
    public ResponseEntity<?> toggleGroup(@PathVariable long id) {
        service.toggleGroup(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalState(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
