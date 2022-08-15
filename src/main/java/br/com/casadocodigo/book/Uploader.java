package br.com.casadocodigo.book;

import org.springframework.web.multipart.MultipartFile;

public interface Uploader {
    String upload(MultipartFile file);
}
