package at.bitmedia.schoolreader.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AudioBlob {
    private byte[] resource;
    public AudioBlob(byte[] r){
        resource = r;
    }
}
