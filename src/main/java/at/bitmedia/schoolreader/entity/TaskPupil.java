package at.bitmedia.schoolreader.entity;

import at.bitmedia.schoolreader.configure.CustomConverter;
import at.bitmedia.schoolreader.configure.CustomConverterType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SR_TASK_PUPIL", schema = "public")

public class TaskPupil {

    @Id
    @Column(name = "SRT_P_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskPupilId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRTA_ID")
    private Task task;
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRP_ID")

    private Pupil pupil;
    private int count_of_solved_repeats;
    @Column(name = "STATUS")
    @Convert(converter = CustomConverter.class)
    private Status status;
    @Column(name = "TYPE")
    @Convert(converter = CustomConverterType.class)
    private TypeTask type;

    public TaskPupil() {
    }

    public TaskPupil(int taskPupilId, Status status, int count_of_repeats) {
        this.taskPupilId = taskPupilId;
        this.status = status;

    }

    @PrePersist
    public void prePersistDate() {
        if (create_date == null && update_date == null) {
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

    public TypeTask getType() {
        return type;
    }

    public void setType(TypeTask type) {
        this.type = type;
    }


    public int getCount_of_solved_repeats() {
        return count_of_solved_repeats;
    }

    public void setCount_of_solved_repeats(int count_of_solved_repeats) {
        this.count_of_solved_repeats = count_of_solved_repeats;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

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


}
