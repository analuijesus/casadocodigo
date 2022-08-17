package br.com.casadocodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public abstract class BookValidator implements Validator {

    private BookRepository bookRepository;

    public BookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewBookForm.class.isAssignableFrom(clazz);
    }

    public abstract Optional<Book> searchBookByField(NewBookForm form);

    public abstract String fieldNameInvalid();

    public abstract String messageError();

    @Override
    public void validate(Object target, Errors errors) {
        NewBookForm form = (NewBookForm) target;

        Optional<Book> bookPossible = searchBookByField(form);

        if (bookPossible.isPresent()) {
            errors.rejectValue(fieldNameInvalid(), null, messageError());
        }
    }
}
