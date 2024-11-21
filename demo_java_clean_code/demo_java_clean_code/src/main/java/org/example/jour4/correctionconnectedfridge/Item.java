package org.example.jour4.correctionconnectedfridge;

import java.time.LocalDateTime;


//@Builder
public class Item {
    private String name;
    private LocalDateTime expirationDate;
    private String condition;

    /*public Item(String name, LocalDateTime expirationDate, String condition) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.condition = condition;
    }*/
    public Item(ItemBuilder itemBuilder) {
        this.name = itemBuilder.name;
        this.condition = itemBuilder.condition;
        this.expirationDate = itemBuilder.expirationDate;
    }

    public String getCondition() {
        return this.condition;
    }

    public LocalDateTime getExpirationDate() {
        return this.expirationDate;
    }

    public String getName() {
        return this.name;
    }

    public static class ItemBuilder {
        private String name;
        private LocalDateTime expirationDate;
        private String condition;

        public ItemBuilder name(String name) {
            this.name = name;
            return this;
        }
        public ItemBuilder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }
        public ItemBuilder condition(String condition) {
            this.condition = condition;
            return this;
        }
        public Item build() {
            return new Item(this);
        }
    }
}
