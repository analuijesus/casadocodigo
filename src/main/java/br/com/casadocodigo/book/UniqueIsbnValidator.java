package br.com.casadocodigo.book;

import java.util.Optional;

public class UniqueIsbnValidator extends BookValidator {

    private BookRepository bookRepository;

    public UniqueIsbnValidator(BookRepository bookRepository) {
        super(bookRepository);
    }

    @Override
    public Optional<Book> searchBookByField(NewBookForm form) {
        return bookRepository.findByIsbn(form.getIsbn());
    }

    @Override
    public String fieldNameInvalid() {
        return "isbn";
    }

    @Override
    public String messageError() {
        return "book.isbn.unique";
    }
}
