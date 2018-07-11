package at.bitmedia.schoolreader.entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SR_CLASS", schema = "public" )

public class Class {
    @Id
    @Column(name = "SRC_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int classId;

    @OneToMany(mappedBy = "class2")
    private Set<TeacherClass> tasksPupil = new HashSet<>();
    @Column(name = "CREATE_DATE")
    private  LocalDateTime create_date;
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

    public Class() {
    }

    public Class(int classId,  String title) {
        this.classId = classId;

        this.title = title;
    }




    @Column(name="TITLE")
    private String title;


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Set<TeacherClass> getTasksPupil() {
        return tasksPupil;
    }

    public void setTasksPupil(Set<TeacherClass> tasksPupil) {
        this.tasksPupil = tasksPupil;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
