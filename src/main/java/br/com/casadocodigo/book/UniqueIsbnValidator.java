package br.com.casadocodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueIsbnValidator implements Validator {
    private BookRepository bookRepository;

    public UniqueIsbnValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewBookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewBookForm form = (NewBookForm) target;
        String isbn = form.getIsbn();

        Optional<Book> bookPossible = bookRepository.findByIsbn(isbn);

        if (bookPossible.isPresent()) {
            errors.rejectValue("isbn", null, "book.isbn.unique");
        }

    }
}
