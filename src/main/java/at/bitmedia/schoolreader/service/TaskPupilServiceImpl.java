package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.entity.TaskPupil;
import at.bitmedia.schoolreader.repositories.ResultRepository;
import at.bitmedia.schoolreader.repositories.TaskPupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskPupilServiceImpl implements TaskPupilService {

    @Autowired
    private TaskPupilRepository taskRepo;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public TaskPupil insertTaskPupil(TaskPupil tp) {
        return taskRepo.save(tp);
    }


    @Override
    public List<Audio> findAllAudiosByTaskId(Integer id) {
        List<Result> resultList = resultRepository
            .findAllByTaskPupil_TaskPupilId(id);
        List<Audio> audios = new ArrayList<>();
        for (Result result : resultList) {
            audios.add(result.getAudio());
        }
        return audios;
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
