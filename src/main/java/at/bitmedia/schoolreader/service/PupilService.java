package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Pupil;
import at.bitmedia.schoolreader.entity.TaskPupil;

import java.util.List;

public interface PupilService extends GenericService<Pupil> {
    Pupil findByUsername(String name);
    List<TaskPupil> findAllTasksByUsername(String name);
}
