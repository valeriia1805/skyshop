package org.skypro.skyshop.domain;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation(Searchable searchable) {
        return searchable.getSearchTerm() + " - " + searchable.getContentType();
    }
}
