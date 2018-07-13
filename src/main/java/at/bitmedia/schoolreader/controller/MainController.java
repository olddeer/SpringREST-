package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Pupil;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.service.PupilServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import at.bitmedia.schoolreader.service.TaskPupilServiceBean;

import java.util.List;

@RestController
@RequestMapping("/pupil")
public class MainController {

    @Autowired
   private PupilServiceBean repo;
@Autowired
private TaskPupilServiceBean taskRepo;

    @RequestMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Pupil>> findAll(){

    return  new ResponseEntity<List<Pupil>>(repo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Pupil> findById(@PathVariable Integer id){
        return  new ResponseEntity<Pupil>(repo.findById(id), HttpStatus.OK);}

    @RequestMapping(value = "/findAllTasks",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<TaskPupil>> findTasks(@RequestParam String username){
        return  new ResponseEntity<List<TaskPupil>>(taskRepo.findAllTasksByUsername(username), HttpStatus.OK);}


}
