package br.com.salutarproject.projetoclinicasalutar.services.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImpl implements IUploadService{

    @Override
    public String uploadFile(MultipartFile arquivo) {

        try {
            System.out.println("DEBUG - Realizando Upload do arquivo: " + arquivo.getOriginalFilename());
            String pastaDestino = "C:\\Users\\felipe\\Desktop\\upload";
            Path path = Paths.get(pastaDestino + File.separator + arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return arquivo.getOriginalFilename();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
