package at.bitmedia.schoolreader.controller;


import at.bitmedia.schoolreader.entity.Pupil;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.service.PupilServiceBean;
import at.bitmedia.schoolreader.service.TaskPupilServiceBean;
import at.bitmedia.schoolreader.service.TaskServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secured/userApi")
public class UserController {


    @Autowired
    private PupilServiceBean repo;
@Autowired
private TaskPupilServiceBean taskBean;


    @RequestMapping(value = "/findAllTasks",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<TaskPupil>> findTasks(){
       Authentication auth =SecurityContextHolder.getContext().getAuthentication();
       return  new ResponseEntity<List<TaskPupil>>(taskBean.findAllTasksByUsername(auth.getName()), HttpStatus.OK);}


    @RequestMapping(name = "/all",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<List<Pupil>> findAll(){
        return  new ResponseEntity<List<Pupil>>(repo.findAll(), HttpStatus.OK);
    }

}
