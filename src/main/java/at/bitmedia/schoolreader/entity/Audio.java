package at.bitmedia.schoolreader.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SR_AUDIO")
@Getter
@Setter

public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sra_id")
    private int sraId;
    private String path;
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;

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

    public int getSraId() {
        return sraId;
    }

    public void setSraId(int st_audio) {
        this.sraId = st_audio;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
