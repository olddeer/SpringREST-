package at.bitmedia.schoolreader.version1.service;

import at.bitmedia.schoolreader.version1.entity.Pupil;
import at.bitmedia.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface PupilService extends  TypicalService<Pupil>{
    Pupil findByUsername(String name);
    List<TaskPupil> findAllTasksByUsername(String name);
}
