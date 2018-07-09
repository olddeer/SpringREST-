package at.bitmedia.schoolreader.version1.service;

import at.bitmedia.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface TaskPupilService  extends  TypicalService<TaskPupil> {


    List<TaskPupil> findByTitle(String title);
    List<TaskPupil> findAllTasksByUsername(String name);
    TaskPupil insertTaskPupil(TaskPupil tp);
}
