package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    Result findByAudio_SraId(Integer id);
    List<Result> findAllByTaskPupil_TaskPupilId(Integer id);

}
