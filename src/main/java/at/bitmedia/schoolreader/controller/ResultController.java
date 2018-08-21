package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.service.AudioServiceImpl;
import at.bitmedia.schoolreader.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/result")

public class ResultController {

    @Autowired
    private AudioServiceImpl audioServiceImpl;
    @Autowired
    private ResultService resultService;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Result getResultById(@PathVariable Integer id) {
        return resultService.findById(id);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    public Result uploadResult(@Valid @RequestBody Result res) {

        return resultService.insertResult(res);
    }

    @PostMapping("/uploadAudio")
    @CrossOrigin(origins = "*")
    public Audio uploadFile(@RequestParam("file") MultipartFile file) {
        return audioServiceImpl.storeFile(file);
    }

    @GetMapping(value = "/downloadFile/{fileName:.+}",
        produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName,
        HttpServletRequest request) {

        byte[] resource = audioServiceImpl.loadFileAsResource(fileName);

        String contentType = null;
        if (contentType == null) {
            contentType = "audio/mp3";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
            .body(resource);
    }
}
