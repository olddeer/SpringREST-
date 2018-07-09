package at.bitmedia.schoolreader.version1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.version1.entity.Pupil;


public interface UserRepo extends JpaRepository<Pupil,Integer> {
   Pupil findByUsername(String username);


}
