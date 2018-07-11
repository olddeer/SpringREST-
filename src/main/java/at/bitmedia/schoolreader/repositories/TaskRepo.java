package at.bitmedia.schoolreader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.entity.Task;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    Task findTaskByDescription(String description);


}
