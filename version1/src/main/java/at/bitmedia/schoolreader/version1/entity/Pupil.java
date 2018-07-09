package at.bitmedia.schoolreader.version1.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="SR_PUPIL")
public class Pupil  implements UserDetails {
    @Id
    @Column(name = "SRP_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pupilId;
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;
    @PrePersist
    public void prePersistDate() {
        if(create_date  == null &&  update_date == null) //We set default value in case if the value is not set yet.
            create_date  = LocalDateTime.now();
        update_date =create_date;
    }
    @PreUpdate
    public void preUpdateDate() {
        update_date = LocalDateTime.now();
    }
    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(Role.USER);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @ManyToOne(fetch =FetchType.EAGER)
  @JoinColumn(name="SRC_ID")
    private at.bitmedia.schoolreader.version1.entity.Class clas;

    public Pupil() {
    }



    @OneToMany(mappedBy = "pupil")

    private Set<TaskPupil> tasksPupil = new HashSet<>();

    public Pupil(int pupilId, String name, String surname, Integer countStars) {
        this.pupilId = pupilId;

        this.name = name;
        this.surname = surname;
        this.countStars = countStars;
    }

    public Set<TaskPupil> getTasksPupil() {
        return tasksPupil;
    }

    public void setTasksPupil(Set<TaskPupil> tasksPupil) {
        this.tasksPupil = tasksPupil;
    }

    private String name;
    private String surname;
    private Integer countStars;
    private String username;
    private String password;

    public Pupil(int pupilId, at.bitmedia.schoolreader.version1.entity.Class clas, String name, String surname, Integer countStars, String username, String password) {
        this.pupilId = pupilId;
        this.clas = clas;
        this.name = name;
        this.surname = surname;
        this.countStars = countStars;
        this.username = username;
        this.password = password;
    }

    public at.bitmedia.schoolreader.version1.entity.Class getClas() {
        return clas;
    }

    public void setClas(at.bitmedia.schoolreader.version1.entity.Class clas) {
        this.clas = clas;
    }


    public int getPupilId() {
        return pupilId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public Integer getCountStars() {
        return countStars;
    }

    public void setCountStars(Integer countStars) {
        this.countStars = countStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return pupilId == pupil.pupilId &&

                Objects.equals(name, pupil.name) &&
                Objects.equals(surname, pupil.surname) &&
                Objects.equals(countStars, pupil.countStars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pupilId,  name, surname, countStars);
    }
}
