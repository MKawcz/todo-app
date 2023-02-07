package pl.edu.pjwstk.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pjwstk.todoapp.model.ProjectStep;
import pl.edu.pjwstk.todoapp.model.projection.ProjectWriteModel;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @GetMapping
    public String showProjects(Model model) {
        model.addAttribute("project", new ProjectWriteModel());
        return "projects";
    }

    @PostMapping(params = "addStep")
    public String addProjectStep(@ModelAttribute("project") ProjectWriteModel current) {
        current.getSteps().add(new ProjectStep());
        return "projects";
    }

}
