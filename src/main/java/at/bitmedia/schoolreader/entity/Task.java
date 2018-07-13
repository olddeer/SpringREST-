package at.bitmedia.schoolreader.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SR_TASK")

public class Task {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return taskId == task.taskId &&
                Objects.equals(location, task.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, location);
    }

    @Id

    @Column(name = "SRTA_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int taskId;
    private String location;
    private String title;
    @OneToMany(mappedBy = "task")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Set<TaskPupil> tasksPupil = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
    public Task(int taskId, String location) {
        this.taskId = taskId;
        this.location = location;

    }
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public Task() {
    }

    public Set<TaskPupil> getTasksPupil() {
        return tasksPupil;
    }

    public void setTasksPupil(Set<TaskPupil> tasksPupil) {
        this.tasksPupil = tasksPupil;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String description) {
        this.location = description;
    }


}
