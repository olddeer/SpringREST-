package at.bitmedia.schoolreader.version1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.version1.entity.Task;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    Task findTaskByDescription(String description);


}
