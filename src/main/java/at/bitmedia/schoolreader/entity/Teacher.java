package at.bitmedia.schoolreader.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SR_TEACHER")
public class Teacher {

    @Id
    @Column(name = "SRT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherClass> teacherClasses = new HashSet<>();
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;
    private String name;
    private String surname;
    private String email;
    private String phone;

    @PrePersist
    public void prePersistDate() {
        if (create_date == null && update_date == null) //We set default value in case if the value is not set yet.
        {
            create_date = LocalDateTime.now();
        }
        update_date = create_date;
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

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public Set<TeacherClass> getTeacherClasses() {
        return teacherClasses;
    }

    public void setTeacherClasses(Set<TeacherClass> teacherClasses) {
        this.teacherClasses = teacherClasses;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public void setSurname(String firstName) {
        this.surname = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
