package com.path2prod;

import java.util.List;

public record Book(String title, String author) {

    public static List<Book> buildBookList(){
        return List.of(
            new Book("title1", "author1"),
            new Book("title2", "author1"),
            new Book("title3", "author1"),
            new Book("title1", "author2"),
            new Book("title2", "author2"),
            new Book("title3", "author2"),
            new Book("title4", "author2"),
            new Book("title1", "author3"),
            new Book("title1", "author4"),
            new Book("title1", "author4")
        );
    }

}
