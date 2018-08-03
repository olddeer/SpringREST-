package at.bitmedia.schoolreader.repositories;

import at.bitmedia.schoolreader.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Integer> {

    Audio findAudioByPath(String path);

}
