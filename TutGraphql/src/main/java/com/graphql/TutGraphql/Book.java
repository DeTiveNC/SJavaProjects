package com.graphql.TutGraphql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(Integer id,
                   String name,
                   Integer pageCount,
                   Integer authorID) {
    public static List<Book> books = Arrays.asList(
            new Book(1, "Hyy", 506, 1),
            new Book(2, "Harry Potter", 554,1),
            new Book(3, "Uie", 88, 2),
            new Book(4, "Ioo", 455,3)
    );


    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
