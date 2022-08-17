package br.com.casadocodigo.book;

import java.util.Optional;

public class UniqueTitleValidator extends BookValidator {

    private BookRepository bookRepository;

    public UniqueTitleValidator(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    public Optional<Book> searchBookByField(NewBookForm form) {
        return bookRepository.findByIsbn(form.getTitle());
    }

    @Override
    public String fieldNameInvalid() {
        return "title";
    }

    @Override
    public String messageError() {
        return "book.title.unique";
    }
}
