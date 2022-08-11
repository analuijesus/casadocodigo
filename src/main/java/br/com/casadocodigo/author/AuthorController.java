package br.com.casadocodigo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping(value = "api/author")
    @Transactional
    public void newAuthor(@Valid @RequestBody NewAuthorForm newAuthorForm) {
        Author newAuthor = newAuthorForm.newAuthor();
        authorRepository.save(newAuthor);
    }
}
