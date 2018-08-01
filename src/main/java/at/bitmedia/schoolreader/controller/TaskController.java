package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.service.TaskPupilService;
import at.bitmedia.schoolreader.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskPup;
    @Autowired
    private TaskPupilService taskPupilServiceBean;

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


}
