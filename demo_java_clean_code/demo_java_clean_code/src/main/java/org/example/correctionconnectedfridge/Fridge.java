package org.example.correctionconnectedfridge;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Fridge {


    private final List<Item> items = new ArrayList<>();

    public void addItem(String name, LocalDateTime expirationDate, String condition) {
        items.add(new Item.ItemBuilder().name(name).condition(condition).expirationDate(expirationDate).build());
    }

    public int getItemsSize() {
        return items.size();
    }

    public Item getItemByName(String itemsName) {
        Optional<Item> optionalItem = searchItemByItem(itemsName);
        if(optionalItem.isPresent()) {
            return optionalItem.get();
        }
        return null;
    }

    private Optional<Item> searchItemByItem(String itemsName) {
        return items.stream().filter(element -> element.getName().equals(itemsName)).findFirst();
    }
}
