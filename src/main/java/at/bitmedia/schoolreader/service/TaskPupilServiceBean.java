package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.repositories.TaskPupilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskPupilServiceBean implements TaskPupilService {

    @Autowired
    private TaskPupilRepo taskRepo;

    @Override
    public TaskPupil insertTaskPupil(TaskPupil tp) {
        return taskRepo.save(tp);
    }

    @Override
    public void updateTask(TaskPupil task){
        taskRepo.save(task);
    }


    @Override
    public List<TaskPupil> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public List<TaskPupil> findByTitle(String title) {
        return taskRepo.findAllByTask_Title(title);
    }

    @Override
    public List<TaskPupil> findAllTasksByUsername(String name) {
        return taskRepo.findAllByPupil_Username(name);
    }

    @Override
    public TaskPupil findById(int id) {
        return taskRepo.findById(id).get();
    }
}
