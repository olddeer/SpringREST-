package at.bitmedia.schoolreader.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SR_AUDIO")
@Getter
@Setter

public class Audio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sra_id;
    private  String path;
    @Column(name = "CREATE_DATE")
    private  LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;
    @PrePersist
    public void prePersistDate() {
        if(create_date  == null &&  update_date == null)
            create_date  = LocalDateTime.now();
        update_date =create_date;
    }
    @PreUpdate
    public void preUpdateDate() {
        update_date = LocalDateTime.now();
    }
    public int getSra_id() {
        return sra_id;
    }

    public void setSra_id(int st_audio) {
        this.sra_id = st_audio;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
