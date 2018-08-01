package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.TaskPupil;

import java.util.List;

public interface TaskPupilService extends GenericService<TaskPupil> {

    void updateTask(TaskPupil task);

    List<TaskPupil> findByTitle(String title);

    List<TaskPupil> findAllTasksByUsername(String name);

    TaskPupil insertTaskPupil(TaskPupil tp);
}
