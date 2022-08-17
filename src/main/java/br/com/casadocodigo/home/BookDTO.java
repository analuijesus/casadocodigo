package br.com.casadocodigo.home;

import br.com.casadocodigo.book.Book;

public class BookDTO {
    private final String title;
    private final String author;

    BookDTO(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthorName();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
