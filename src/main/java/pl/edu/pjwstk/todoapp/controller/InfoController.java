package pl.edu.pjwstk.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.todoapp.TaskConfigurationProperties;

@RestController
public class InfoController {
    private DataSourceProperties dataSource;
    private TaskConfigurationProperties myprop;

    public InfoController(DataSourceProperties dataSource, TaskConfigurationProperties myprop) {
        this.dataSource = dataSource;
        this.myprop = myprop;
    }

    @GetMapping("/info/url")
    public String url(){
        return dataSource.getUrl();
    }

    @GetMapping("/info/prop")
    public boolean myProp() {
        return myprop.isAllowMultipleTasksFromTemplate();
    }
}
