package com.sity.model.request;

import com.sity.model.Author;
import com.sity.model.Publisher;

import java.util.Set;

public record BookRequest(
        String title,
        String category,
        Long isbn,
        Set<Publisher> publisher,
        Set<Author> author,
        Boolean isPublished
) {

}
