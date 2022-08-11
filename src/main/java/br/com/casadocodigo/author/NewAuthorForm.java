package br.com.casadocodigo.author;

import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotBlank;

public class NewAuthorForm {

    @NotBlank
    private String name;
    @NotBlank
    @URL
    private String urlGithub;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlGithub() {
        return urlGithub;
    }

    public void setUrlGithub(String urlGithub) {
        this.urlGithub = urlGithub;
    }

    public Author newAuthor() {
        return new Author(name, urlGithub);
    }
}
