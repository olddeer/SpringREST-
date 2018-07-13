package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/secured/tasks")
@Slf4j
public class TaskController {
    @Autowired
    TaskServiceBean taskPup;

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Task>> allTasks() {
        return new ResponseEntity<List<Task>>(taskPup.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task tp) {
        return new ResponseEntity<Task>(taskPup.insertTask(tp), HttpStatus.OK);
    }


}
