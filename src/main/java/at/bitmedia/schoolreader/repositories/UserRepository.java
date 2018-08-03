package at.bitmedia.schoolreader.repositories;


import at.bitmedia.schoolreader.entity.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Pupil, Integer> {

    Pupil findByUsername(String username);


}
