package ru.croc.java.school.lesson6.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BooksConvertTest {

    @Test
    public void simpleTest() throws IOException {
        final XmlConverter xmlConverter = new XmlConverter();
        final Book book = new Book("Книга 1", "Автор 1");
        final String actual = xmlConverter.toXml(book);
//        Path path = Paths.get("src/test/resources", "simpleBookTest.xml");
//        final String expected = Files.readString(path);
//        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTest2() throws IOException {
        final XmlConverter xmlConverter = new XmlConverter();
        final Book book = new Book("Книга 1", "Автор 1");
        String xml = xmlConverter.toXml(book);
        Book actual = xmlConverter.fromXml(xml, Book.class);

        Assertions.assertEquals(book, actual);
    }

    @Test
    public void simpleTest3() throws IOException {
        final XmlConverter xmlConverter = new XmlConverter();
        final Book book = new Book("Книга 1", "Автор 1");
        final String actual = xmlConverter.toXml(book);

        final String expected = "";
        Assertions.assertEquals(expected, actual);
    }

}
