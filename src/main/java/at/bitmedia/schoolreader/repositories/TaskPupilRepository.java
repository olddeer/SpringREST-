package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.TaskPupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskPupilRepository extends JpaRepository<TaskPupil, Integer> {
    @Query("UPDATE TaskPupil task SET task.update_date = CURRENT_TIME")
    void updateTask(TaskPupil task);
    List<TaskPupil> findAllByPupil_Username(String surname);
    List<TaskPupil> findAllByTask_Title(String title);
}
