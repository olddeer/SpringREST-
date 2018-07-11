package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.entity.TaskPupil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result,Integer> {
    
}
