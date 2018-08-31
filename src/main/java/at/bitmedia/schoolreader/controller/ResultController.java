package at.bitmedia.schoolreader.controller;

import at.bitmedia.schoolreader.entity.Audio;
import at.bitmedia.schoolreader.entity.Result;
import at.bitmedia.schoolreader.service.AudioService;
import at.bitmedia.schoolreader.service.ResultService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/result")

public class ResultController {

    @Autowired
    private AudioService audioService;

    @Autowired
    private ResultService resultService;


    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Result getResultById(@PathVariable Integer id) {
        return resultService.findById(id);
    }


    @GetMapping("/getByAudioId")
    @CrossOrigin(origins = "*")
    public Result getResultByAudioId(@RequestParam Integer id) {
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

        return audioService.storeFile(file);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {

        Resource resource = audioService.loadFileAsResource(fileName);
        String contentType = "audio/mp3";

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName )
            .body(resource);
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
