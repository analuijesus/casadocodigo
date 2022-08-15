package br.com.casadocodigo.book;

import br.com.casadocodigo.author.Author;
import br.com.casadocodigo.author.AuthorRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class NewBookForm {

    @NotBlank
    private String title;
    @NotBlank
    private String caption;
    @Min(20)
    private BigDecimal price;
    @NotBlank
    private String content;
    private String summary;
    @Min(50)
    private int numberPages;
    @NotBlank
    private String isbn;
    @URL
    @NotBlank
    private MultipartFile bookCoverLink;
    @NotNull
    private Long idAuthor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public MultipartFile getBookCoverLink() {
        return bookCoverLink;
    }

    public void setBookCoverLink(MultipartFile bookCoverLink) {
        this.bookCoverLink = bookCoverLink;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Book newBook(AuthorRepository authorRepository, Uploader uploader) {
        Author author = authorRepository.findById(idAuthor).get();
        String cover = uploader.upload(bookCoverLink);
        return new Book(title, caption, price, content, summary, numberPages, isbn, cover, author);
    }
}
