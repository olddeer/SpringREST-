package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Pupil;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.repositories.TaskPupilRepository;
import at.bitmedia.schoolreader.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PupilServiceImpl implements PupilService {

    @Autowired
   private UserRepository userRepository;

    @Autowired
   private TaskPupilRepository taskRepo;

    @Override
    public Pupil findById(int id) {
        Pupil newPupil = userRepository.findById(id).get();
        return newPupil;
    }

    @Override
    public List<Pupil> findAll() {
        List<Pupil> list = userRepository.findAll();
        return list;
    }

    @Override
    public Pupil findByUsername(String name) {
      Pupil newPupil = userRepository.findByUsername(name);
        return newPupil;
    }

    @Override
    public List<TaskPupil> findAllTasksByUsername(String name) {
        List<TaskPupil> list = taskRepo.findAllByPupil_Username(name);
        return list;
    }
}
