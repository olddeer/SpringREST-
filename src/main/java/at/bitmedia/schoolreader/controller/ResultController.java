package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.service.AudioService;
import at.bitmedia.schoolreader.service.ResultServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/schoolreader-api/result")

public class ResultController {

    @Autowired
    private AudioService fileStorageService;
    @Autowired
    private ResultServiceBean resBean;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Result getResultById(@PathVariable Integer id) {
        return resBean.findById(id);
    }


    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Result> getResultAll() {
        return resBean.findAll();
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public Result uploadResult(@Valid @RequestBody Result res) {
        return resBean.insertResult(res);
    }

    @PostMapping("/uploadAudio")
    @CrossOrigin(origins = "*")
    public Audio uploadFile(@RequestParam("file") MultipartFile file) {
        return fileStorageService.storeFile(file);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileName,
        HttpServletRequest request) {

        org.springframework.core.io.Resource resource = fileStorageService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
    }
}
