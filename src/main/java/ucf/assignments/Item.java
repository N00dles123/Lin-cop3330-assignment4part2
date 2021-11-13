package ucf.assignments;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Item {
    private String description;
    private Date time;
    private boolean complete;
    public Item(String description, String time, boolean complete) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        this.description = description;
        this.time = formatter.parse(time);
        this.complete = complete;
    }
    public Item(String description, String time) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        this.description = description;
        this.time = formatter.parse(time);
        this.complete = false;
    }
    public void setTime(String someTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        this.time = formatter.parse(someTime);
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
    public String getTime(){
        /*
        This function will get the LocalDate object and covert it to a string
        in YYYY-MM-DD format
         */
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String day = dateFormat.format(this.time);
        return day;
    }
    public void setDescription(String descr){
        this.description = descr;
        /*
        This function will set or change the description of the Item
         */
    }
    public void setComplete(){
        this.complete = true;
        /*
        This function will make the Item complete on the ToDo List
         */
    }
    public void setIncomplete(){
        this.complete = false;
        /*
        This function will make the Item incomplete on the ToDo List
         */
    }
    public String getComplete(){
        String comp = "false";
        if(this.complete == true)
            comp = "true";
        return comp;
    }


}
