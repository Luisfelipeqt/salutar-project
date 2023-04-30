package br.com.salutarproject.projetoclinicasalutar.services.upload;

import org.springframework.web.multipart.MultipartFile;
public interface IUploadService {

    String uploadFile(MultipartFile arquivo);
}
