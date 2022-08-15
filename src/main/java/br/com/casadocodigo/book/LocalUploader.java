package br.com.casadocodigo.book;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader{
    @Override
    public String upload(MultipartFile file) {
        return "http://s3/bucket/" + file.getOriginalFilename();
    }
}
