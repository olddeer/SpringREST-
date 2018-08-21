package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.TaskPupil;

import java.util.List;

public interface TaskPupilService extends GenericService<TaskPupil> {

    TaskPupil updateTask(TaskPupil task);

    List<TaskPupil> findByTitle(String title);

    List<TaskPupil> findAllTasksByUsername(String name);
    List<Audio> findAllAudiosByTaskId(Integer id);
    TaskPupil insertTaskPupil(TaskPupil tp);
}
