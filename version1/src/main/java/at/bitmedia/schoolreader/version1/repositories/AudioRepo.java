package at.bitmedia.schoolreader.version1.repositories;

import at.bitmedia.schoolreader.version1.entity.Audio;
import at.bitmedia.schoolreader.version1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AudioRepo extends JpaRepository<Audio,Integer> {
    Audio findAudioByPath(String path);

}
