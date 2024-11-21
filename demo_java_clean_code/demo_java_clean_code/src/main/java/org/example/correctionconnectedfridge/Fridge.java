package org.example.correctionconnectedfridge;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    //No Respect of Solid
    public String displayItems() {

        Stream<Item> displayElementsInsideFridge = items.stream();
        Stream<String> displayStringElementInsideFridge = displayElementsInsideFridge.map(item ->getStringItemInsideFridge(item));
        return displayStringElementInsideFridge.collect(Collectors.joining("\n"));

        /*return items.stream()
                .sorted(Comparator.comparing(Item::getExpirationDate))
                .map(item -> {
                    if (item.getExpirationDate().isBefore(LocalDateTime.now())) {
                        return "EXPIRED: " + item.getName();
                    } else {
                        long daysRemaining = Duration.between(LocalDateTime.now(), item.getExpirationDate()).toDays();
                        return item.getName() + ": " + daysRemaining + " day(s) remaining";
                    }
                })
                .collect(Collectors.joining("\n"));*/
    }

    private String getStringItemInsideFridge(Item item) {
        if (item.getExpirationDate().isBefore(LocalDateTime.now())) {
            return "EXPIRED: " + item.getName();
        } else {
            long daysRemaining = Duration.between(LocalDateTime.now(), item.getExpirationDate()).toDays();
            return item.getName() + ": " + daysRemaining + " day(s) remaining";
        }
    }
}
