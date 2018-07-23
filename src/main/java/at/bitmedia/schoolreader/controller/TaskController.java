package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.service.TaskPupilServiceBean;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/schoolreader-api/tasks")
@Slf4j
public class TaskController {

    @Autowired
    private TaskServiceBean taskPup;
    @Autowired
    private TaskPupilServiceBean taskPupilServiceBean;

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Task>> allTasks() {
        return new ResponseEntity<List<Task>>(taskPup.findAll(), HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<TaskPupil>> taskByUsername(@RequestParam String username) {
        return new ResponseEntity<List<TaskPupil>>(taskPupilServiceBean.findAllTasksByUsername(username),
            HttpStatus.OK);
    }

    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task tp) {
        return new ResponseEntity<Task>(taskPup.insertTask(tp), HttpStatus.OK);
    }


}
