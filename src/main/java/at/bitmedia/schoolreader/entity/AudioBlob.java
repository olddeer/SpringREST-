package at.bitmedia.schoolreader.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioBlob {
    private String resource;
   private String toBinary( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }
    public AudioBlob(byte[] r){
        resource =toBinary(r);
    }
}
