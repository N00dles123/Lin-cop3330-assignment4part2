package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    ToDo list = new ToDo("food");
    @Test
    void getItems() throws ParseException {
        list.addItem(new Item("laundry","2021-11-11"));
        ArrayList<Item> testList = list.getItems();
        assertEquals(testList.get(0).getComplete(), "false");
    }

    @Test
    void getTitle() {
        assertEquals(list.getTitle(),"food");
    }

    @Test
    void findItem() throws ParseException {
        list.addItem(new Item("laundry","2021-11-11"));
        Item something = list.findItem("laundry");
        assertEquals(something.getComplete(), "false");
    }

    @Test
    void loadincomplete() throws ParseException{
        list.addItem(new Item("laundry","2021-11-11"));
        ArrayList<Item> incomp = list.loadincomplete(list);
        assertEquals(incomp.get(0).getComplete(),"false");

    }

    @Test
    void loadcomplete() throws ParseException{
        list.addItem(new Item("laundry","2021-11-11"));
        ArrayList<Item> comp = list.loadcomplete(list);
        assertEquals(comp.size(),0);
    }
}