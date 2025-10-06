package org.skypro.skyshop.engine;

import org.skypro.skyshop.domain.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> items;

    public SearchEngine() {
        items = new ArrayList<>();
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new  ArrayList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().contains(query)) {
                result.add(item);
            }
        }
        return result;
    }

    public Searchable searchMostRelevant(String search) throws BestResultNotFound {
        Searchable result = null;
        int maxCount = 0;
        for (Searchable item : items) {
            String str = item.getSearchTerm();
            int count = 0;
            int index = 0;
            int matchIndex = str.indexOf(search, index);

            while (matchIndex != -1) {
                count++;
                index = matchIndex + search.length();
                matchIndex = str.indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                result = item;
            }
        }

        if (result == null) {
            throw new BestResultNotFound(search);
        }
        return result;
    }

    public void add(Searchable item) {
        items.add(item);
    }
}
