package br.com.casadocodigo.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class UniqueBookTitleValidator implements Validator {

    private BookRepository bookRepository;

    public UniqueBookTitleValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewBookForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewBookForm form = (NewBookForm) target;
        String title = form.getTitle();

        Optional<Book> bookPossible = bookRepository.findByTitle(title);

        if (bookPossible.isPresent()) {
            errors.rejectValue("title", null, "book.title.unique");
        }
    }
}
