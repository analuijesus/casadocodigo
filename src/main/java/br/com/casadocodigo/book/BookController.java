package br.com.casadocodigo.book;

import br.com.casadocodigo.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private Uploader uploader;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(new UniqueIsbnValidator(bookRepository), new UniqueTitleValidator(bookRepository));
    }

    @PostMapping(value = "api/book")
    public void newBook(@Valid @RequestBody NewBookForm newBookForm) {
        Book newBook = newBookForm.newBook(authorRepository, uploader);
        bookRepository.save(newBook);
    }
}
