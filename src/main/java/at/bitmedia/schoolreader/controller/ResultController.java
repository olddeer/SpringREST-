package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.AudioBlob;
import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.service.AudioServiceImpl;
import at.bitmedia.schoolreader.service.ResultService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.sql.SQLException;

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
        produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<AudioBlob> downloadFile(@PathVariable String fileName) throws SQLException {

        byte[] resource = audioServiceImpl.loadFileAsResource(fileName);

       AudioBlob blob = new AudioBlob(resource);

        return ResponseEntity.ok()
            .body(blob);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(
            SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }
}
