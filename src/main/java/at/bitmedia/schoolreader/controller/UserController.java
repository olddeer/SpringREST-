package at.bitmedia.schoolreader.controller;


import at.bitmedia.schoolreader.entity.Pupil;
import at.bitmedia.schoolreader.service.PupilServiceBean;
import at.bitmedia.schoolreader.service.TaskPupilServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schoolreader-api/users")
public class UserController {


    @Autowired
    private PupilServiceBean repo;
    @Autowired
    private TaskPupilServiceBean taskBean;


    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Pupil>> findAll() {
        return new ResponseEntity<List<Pupil>>(repo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Pupil> getUser(@RequestParam String username) {
        return new ResponseEntity<Pupil>(repo.findByUsername(username), HttpStatus.OK);
    }


}