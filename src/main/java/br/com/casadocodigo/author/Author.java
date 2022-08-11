package br.com.casadocodigo.author;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @URL
    private String urlGithub;
    @PastOrPresent
    private LocalDateTime atCreate = LocalDateTime.now();

    public Author(String name, String urlGithub) {
        this.name = name;
        this.urlGithub = urlGithub;
    }

    @Deprecated
    public Author() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
