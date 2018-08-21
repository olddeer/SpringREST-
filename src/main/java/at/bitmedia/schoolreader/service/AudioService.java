package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Audio;
import org.springframework.web.multipart.MultipartFile;

public interface AudioService extends GenericService<Audio> {

    Audio storeFile(MultipartFile file);

    byte[] loadFileAsResource(String fileName);

}
