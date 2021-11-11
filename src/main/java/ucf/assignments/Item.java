package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
import java.time.LocalDate;
import java.text.SimpleDateFormat;
public class Item {
    String description;
    LocalDate time;
    boolean complete;
    public Item(String description, String time, boolean complete){
        this.description = description;
        this.time = LocalDate.parse(time);
        this.complete = complete;
    }
    public void setTime(String someTime){
        time = LocalDate.parse(someTime);
        /*
        sets time or due date of the Item
        also allows to change the due date of the item
         */
    }
    public String getDescription(){
        /*
        this is a getter function that gets the item's description
        on the todo list
         */
        return description;
    }
    public String getDate(){
        /*
        This function will get the LocalDate object and covert it to a string
        in YYYY-MM-DD format
         */
        return "";
    }
    public void setDescription(String descr){
        /*
        This function will set or change the description of the Item
         */
    }
    public void setComplete(){
        /*
        This function will make the Item complete on the ToDo List
         */
    }
    public void setIncomplete(){
        /*
        This function will make the Item incomplete on the ToDo List
         */
    }


}
