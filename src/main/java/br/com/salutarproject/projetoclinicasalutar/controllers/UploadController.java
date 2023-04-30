package br.com.salutarproject.projetoclinicasalutar.controllers;

import br.com.salutarproject.projetoclinicasalutar.services.upload.IUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UploadController {

    private final IUploadService uploadService;


    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam(name = "arquivo") MultipartFile arquivo) {
        String filename = uploadService.uploadFile(arquivo);
        if (filename != null) {
            return ResponseEntity.status(201).body("Upload com sucesso!");
        }
        return ResponseEntity.badRequest().build();
    }
}
