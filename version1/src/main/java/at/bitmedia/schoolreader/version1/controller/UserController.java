package at.bitmedia.schoolreader.version1.controller;


import at.bitmedia.schoolreader.version1.entity.Pupil;
import at.bitmedia.schoolreader.version1.service.PupilServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secured/userApi")
public class UserController {


    @Autowired
    private PupilServiceBean repo;


    @RequestMapping(name = "/all",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<List<Pupil>> findAll(){
        return  new ResponseEntity<List<Pupil>>(repo.findAll(), HttpStatus.OK);
    }

}
