package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.repositories.CustomizedSaveImpl;

import java.util.List;
@Service
public class TaskServiceBean implements TaskService {
   @Autowired
   TaskRepo taskRepo;

    @Override
    public Task insertTask(Task tp) {
        CustomizedSaveImpl<Task> taskSave =new CustomizedSaveImpl<Task>();


        return taskSave.save(tp);
    }

    @Override
    public Task findByDescription(String desk) {
        return taskRepo.findTaskByTitle(desk);
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public Task findById(int id) {
        return taskRepo.findById(id).get();
    }
}
