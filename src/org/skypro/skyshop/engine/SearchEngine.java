package org.skypro.skyshop.engine;

import org.skypro.skyshop.domain.Searchable;

public class SearchEngine {

    private Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
        size = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int index = 0;
        for (int i = 0; i < size; i++) {
            Searchable item = items[i];
            if (item.getSearchTerm().contains(query)) {
                result[index] = item;
                index++;
            }
            if (index == 5) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size] = item;
        size++;
    }

    private void resize(int newCapacity) {
        Searchable[] newItems = new Searchable[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
}
