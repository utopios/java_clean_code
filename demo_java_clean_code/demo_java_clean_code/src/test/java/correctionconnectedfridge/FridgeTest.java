package correctionconnectedfridge;

import org.example.correctionconnectedfridge.Fridge;
import org.example.correctionconnectedfridge.Item;
import org.example.demotdd.FizzBuzz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FridgeTest {


    private Fridge fridge;
    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @Test
    @DisplayName("Should return size of items (1) inside the fridge when i add 1 item")
    void testAddItem() {
        fridge.addItem("Milk", LocalDateTime.of(2024,11,30,10,0), "sealed");

        assertEquals(1, fridge.getItemsSize());
    }

    @Test
    @DisplayName("Should return size of items (2) inside the fridge when i add 2 items")
    void testAddTwoItems() {
        fridge.addItem("Milk", LocalDateTime.of(2024,11,30,10,0), "sealed");
        fridge.addItem("Sauce", LocalDateTime.of(2024,12,1,10,0), "notSealed");

        assertEquals(2, fridge.getItemsSize());
    }

    @Test
    @DisplayName("Should get item's properties when i add 1 item inside the fridge")
    void testPropertiesItemWhenAddItem() {
        fridge.addItem("Milk", LocalDateTime.of(2024,11,30,10,0), "sealed");
        Item item = fridge.getItemByName("Milk");

        assertEquals("sealed", item.getCondition());
        assertEquals(LocalDateTime.of(2024,11,30,10,0), item.getExpirationDate());
        assertEquals("milk", item.getName());
    }

}
