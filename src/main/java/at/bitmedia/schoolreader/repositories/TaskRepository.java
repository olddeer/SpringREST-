package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findTaskByTitle(String description);

    Task findTaskByLocation(String description);

}
