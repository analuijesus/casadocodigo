package br.com.casadocodigo.author;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "api/author")
    @Transactional
    public void newAuthor(@Valid @RequestBody NewAuthorForm newAuthorForm) {
        Author newAuthor = newAuthorForm.newAuthor();
        entityManager.persist(newAuthor);
    }
}
