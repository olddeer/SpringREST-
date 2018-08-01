package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.FileStorageProperties;
import at.bitmedia.schoolreader.exceptions.FileStorageException;
import at.bitmedia.schoolreader.exceptions.MyFileNotFoundException;
import at.bitmedia.schoolreader.repositories.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

@Service
public class AudioService {

    private final Path fileStorageLocation;
    @Value("file.upload-dir")
    private String path;
    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    public AudioService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
            .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                ex);
        }
    }

    public Audio storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            fileName = Base64.getEncoder().encodeToString(fileName.getBytes("utf-8"));

               if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Audio newAudio = new Audio();

            newAudio.setPath(fileName.toString());

              Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return audioRepository.save(newAudio);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {

            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
