package br.com.casadocodigo.book;

import br.com.casadocodigo.author.Author;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String caption;
    @Min(20)
    private BigDecimal price;
    @NotBlank
    private String content;
    @NotBlank
    private String summary;
    @Min(50)
    private int numberPages;
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @NotBlank
    @URL
    private String bookCoverLink;
    @ManyToOne
    private Author author;

    public Book(String title, String caption, BigDecimal price, String content, String summary, int numberPages, String isbn, String bookCoverLink, Author author) {

        this.title = title;
        this.caption = caption;
        this.price = price;
        this.content = content;
        this.summary = summary;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.bookCoverLink = bookCoverLink;
        this.author = author;
    }

    @Deprecated
    public Book() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
