package org.skypro.skyshop.engine;

import org.skypro.skyshop.domain.Searchable;
import org.skypro.skyshop.domain.SearchableComparator;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {

    private Set<Searchable> items;

    public SearchEngine() {
        items = new HashSet<>();
    }

    public Set<Searchable> search(String query) {
        return items.stream()
                .filter(item -> item.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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
