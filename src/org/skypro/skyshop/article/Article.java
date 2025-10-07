package org.skypro.skyshop.article;

import org.skypro.skyshop.domain.Searchable;

public class Article implements Searchable {

    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Article article = (Article) o;
        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
