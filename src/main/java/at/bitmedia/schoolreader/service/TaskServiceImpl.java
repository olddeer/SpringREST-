package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Task;
import at.bitmedia.schoolreader.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findByDescription(String desk) {
        return taskRepository.findTaskByTitle(desk);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id).get();
    }
}
