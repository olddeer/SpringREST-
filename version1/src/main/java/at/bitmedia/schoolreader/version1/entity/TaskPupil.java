package at.bitmedia.schoolreader.version1.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import at.bitmedia.schoolreader.version1.configure.CustomConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SR_TASK_PUPIL", schema = "public")

public class TaskPupil {
    public TaskPupil() {
    }

    public TaskPupil(int taskPupilId,  Status status, int count) {
        this.taskPupilId = taskPupilId;
        this.status = status;
        this.count = count;
    }

    @Id
    @Column(name = "SRT_P_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int taskPupilId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "SRTA_ID")
        @JsonIgnore
    private Task task;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRP_ID")
    @JsonIgnore
    private  Pupil pupil;
    @Column
    @Convert(converter = CustomConverter.class)
    private  Status status;
    private int count;




    public int getTaskPupilId() {
        return taskPupilId;
    }

    public void setTaskPupilId(int taskPupilId) {
        this.taskPupilId = taskPupilId;
    }



    public Serializable getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
