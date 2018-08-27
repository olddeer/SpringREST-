package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.FileStorageProperties;
import at.bitmedia.schoolreader.exceptions.FileStorageException;
import at.bitmedia.schoolreader.exceptions.MyFileNotFoundException;
import at.bitmedia.schoolreader.repositories.AudioRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {

    private final Path fileStorageLocation;
    @Value("file.upload-dir")
    private String path;
    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    public AudioServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
            .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                ex);
        }
    }

    @Override
    public List<Audio> findAll() {
        return audioRepository.findAll();
    }

    @Override
    public Audio findById(int id) {
        return audioRepository.findById(id).get();
    }

    @Override
    public Audio storeFile(MultipartFile file) {

        String fileName = null;
        try {
            fileName = Base64.getEncoder().encodeToString(file.getOriginalFilename().getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
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

    @Override
    public byte[] loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            File file = filePath.toFile();
            Resource resource = new UrlResource(filePath.toUri());
            InputStream fs = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(fs);
            if (resource.exists()) {
                return bytes;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
