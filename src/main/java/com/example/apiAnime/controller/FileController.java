package com.example.apiAnime.controller;

import com.example.apiAnime.domain.dto.AnimeError;
import com.example.apiAnime.domain.model.Anime;
import com.example.apiAnime.domain.model.File;
import com.example.apiAnime.domain.model.User;
import com.example.apiAnime.repository.FileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileRepository fileRepository;
    FileController(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @GetMapping("/")
    public List<File> findAllFiles(){return fileRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<?> getFile(@PathVariable UUID id) {
        File file = fileRepository.findById(id).orElse(null);

        if (file == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnimeError.message("No s'ha trobat l'arxiu amd id '" + id + "'"));

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.contenttype))
                .contentLength(file.data.length)
                .body(file.data);
    }

    @PostMapping("/")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            return ResponseEntity.ok().body(fileRepository.save(file));
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable UUID id){
        File file = fileRepository.findById(id).orElse(null);
        if (file != null) {
            fileRepository.delete(file);
            return  ResponseEntity.ok().body(AnimeError.message("S'ha eliminat l'arxiu amd id " + "'" + id + "'"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnimeError.message("No s'ha trobat l'arxiu amb id '" + id + "'"));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllFiles(){
        fileRepository.deleteAll();
        return ResponseEntity.ok().body(AnimeError.message("S'han esborrat tots els arxius"));
    }

}
