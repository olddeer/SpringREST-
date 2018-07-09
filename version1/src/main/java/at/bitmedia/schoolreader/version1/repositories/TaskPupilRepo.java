package at.bitmedia.schoolreader.version1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface TaskPupilRepo extends JpaRepository<TaskPupil,Integer>{
    List<TaskPupil> findAllByPupil_Username(String surname);
                        List<TaskPupil> findAllByTask_Description(String description);
}
