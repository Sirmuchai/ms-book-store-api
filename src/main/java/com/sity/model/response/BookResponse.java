package com.sity.model.response;

import com.sity.model.Author;
import com.sity.model.Publisher;

import java.util.Set;

public record BookResponse(
        Integer id,
        String title,
        String category,
        Long isbn,
        Set<Publisher> publisher,
        Set<Author> author,
        Boolean isPublished
) {


}
