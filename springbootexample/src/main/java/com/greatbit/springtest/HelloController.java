package com.greatbit.springtest;

import com.greatbit.springtest.model.BookStorage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/books")
    public String books() {
        return BookStorage.getBooks().stream().
                map(book -> book.getName() + " - " + book.getAuthor()).
                collect(Collectors.joining("<br>"));
    }
}
