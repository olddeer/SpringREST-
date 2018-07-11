package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AudioRepo extends JpaRepository<Audio,Integer> {
    Audio findAudioByPath(String path);

}
