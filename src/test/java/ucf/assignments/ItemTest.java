package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item item = new Item("food", "2021-08-15");

    ItemTest() throws ParseException {
    }

    @Test
    void getDescription() {
        assertEquals(item.getDescription(), "food");
    }

    @Test
    void getTime() {
        assertEquals(item.getTime(),"2021-08-15");
    }

    @Test
    void getComplete() {
        assertEquals(item.getComplete(), "false");
    }
}