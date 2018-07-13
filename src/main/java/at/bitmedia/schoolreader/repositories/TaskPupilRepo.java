package at.bitmedia.schoolreader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.entity.TaskPupil;

import java.util.List;

public interface TaskPupilRepo extends JpaRepository<TaskPupil,Integer>{
    List<TaskPupil> findAllByPupil_Username(String surname);
    List<TaskPupil> findAllByTask_Title(String title);
}
