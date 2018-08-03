package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.TaskPupil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskPupilRepository extends JpaRepository<TaskPupil, Integer> {

    List<TaskPupil> findAllByPupil_Username(String surname);

    List<TaskPupil> findAllByTask_Title(String title);
}
