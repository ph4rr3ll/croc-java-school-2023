package ru.croc.java.school.lesson6.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    @XmlElement(name = "Название")
    private String title;
    @XmlElementWrapper(name = "Авторы")
    @XmlElement(name = "Автор")
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(new Author(author, 4));
    }

    public Book(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthors(), book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthors());
    }
}
