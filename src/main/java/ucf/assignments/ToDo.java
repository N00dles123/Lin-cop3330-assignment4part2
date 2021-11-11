package ucf.assignments;
import java.io.File;
import java.util.*;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
public class ToDo {
    String Title;
    ArrayList<Item> items;
    public ToDo(String Title){
        this.Title = Title;
        items = new ArrayList<>();
    }
    public void addItem(Item something){
        //items.add(something);
        /*
        this function adds an item to the list
         */
    }
    public void changeTitle(String nTitle){
        /*
        This function will change the title of the list
         */
    }
    public String getTitle(){
        return Title;
    }
    public Item findItem(String name){
        Item foundItem = null;
        /*
        purpose of this function is to return the item that they are looking for
         */
        return foundItem;
    }
    public void removeItem(String name){
        /*
        purpose of this function is to remove the item by finding the item first through
        the findItem function
         */
    }
    public void saveList(){
        /*
        purpose of this function is to save the current list to a .csv file utilizing
        the File class
         */
    }
    public ToDo loadList(File input){
        ToDo temp = null;
        /*
        This function will create a todo list
        based on the saved csv file and then upload to the javafx gui
         */
        return temp;
    }
    public ArrayList<Item> loadincomplete(ToDo list){
        ArrayList<Item> incomplete= null;
        /*
        function will traverse through the ToDo list and
        add the incomplete items to it and then return that list
         */
        return incomplete;
    }
    public ArrayList<Item> loadcomplete(ToDo list){
        ArrayList<Item> complete= null;
        /*
        function will traverse through the ToDo list and
        add the complete items to it and then return that list
         */
        return complete;
    }
}
