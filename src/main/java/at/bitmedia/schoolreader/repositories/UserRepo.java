package at.bitmedia.schoolreader.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import at.bitmedia.schoolreader.entity.Pupil;


public interface UserRepo extends JpaRepository<Pupil,Integer> {
   Pupil findByUsername(String username);


}
