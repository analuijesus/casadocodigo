package br.com.casadocodigo.home;

import br.com.casadocodigo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/home")
    public List<BookDTO> listBooks() {
       return bookRepository.findAll().stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }
}
