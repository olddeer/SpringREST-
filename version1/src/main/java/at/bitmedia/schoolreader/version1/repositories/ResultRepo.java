package at.bitmedia.schoolreader.version1.repositories;

import at.bitmedia.schoolreader.version1.entity.Result;
import at.bitmedia.schoolreader.version1.entity.TaskPupil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result,Integer> {
    
}
