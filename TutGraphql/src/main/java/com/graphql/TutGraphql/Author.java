package com.graphql.TutGraphql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Author(Integer id,
                     String firstName,
                     String lastName) {
    public static List<Author> authors = Arrays.asList(
            new Author(1, "Sedd", "Iuoo"),
            new Author(2, "Iwwq", "Iooq1"),
            new Author(3, "yuuio", "kjl")
    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(b -> b.id.equals(id))
                .findFirst();
    }
}
