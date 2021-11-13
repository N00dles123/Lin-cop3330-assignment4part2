package ucf.assignments;
import java.io.File;
import java.io.*;
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
        this.items = new ArrayList<>();
    }
    public ToDo(){
        this.Title = null;
        this.items = new ArrayList<>();
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public void addItem(Item something){
        items.add(something);
        /*
        this function adds an item to the list
         */
    }
    public void changeTitle(String nTitle){
        /*
        This function will change the title of the list
         */
        this.Title = nTitle;
    }
    public String getTitle(){
        return Title;
    }
    public Item findItem(String name){
        Item foundItem = null;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getDescription().equalsIgnoreCase(name)) {
                foundItem = items.get(i);
                break;
            }
        }
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
        items.remove(findItem(name));
    }
    public void saveList(){
        /*
        purpose of this function is to save the current list to a .txt file utilizing
        the File class
         */
        String path ="src\\main\\java\\ucf\\assignments" + this.Title + ".txt";
        try {
            File folder = new File(path);
            PrintWriter writer = new PrintWriter(path);
            writer.write(this.Title+"\n");
            for(int i = 0; i < items.size(); i++){
                writer.write(items.get(i).getDescription()+",");
                writer.write(items.get(i).getTime()+",");
                writer.write(items.get(i).getComplete()+",");
                writer.write("\n");
            }
            writer.close();
        }catch(Exception e){
            System.out.println("error");
        }
    }
    /*
        This function will create a todo list
        based on the saved csv file and then upload to the javafx gui
         */
    public void loadList(File input){
        //ToDo temp = null;
        try {
            Scanner in = new Scanner(input);
            ArrayList<String> out = new ArrayList<>();
            while (in.hasNextLine()) {
                out.add(in.nextLine());
            }
            String temparr = out.get(0);
            this.Title = temparr;
            for(int i = 1; i < out.size(); i++){
                System.out.println(out.get(i));
                String[] temporary = out.get(i).split(",");
                addItem(new Item(temporary[0],temporary[1],Boolean.parseBoolean(temporary[2])));
                System.out.println(out.size());
            }
        }catch(Exception e){
            System.out.println("failed");
        }


        //return temp;
    }
    public ArrayList<Item> loadincomplete(ToDo list){
        ArrayList<Item> incomplete = new ArrayList<>();
        /*
        function will traverse through the ToDo list and
        add the incomplete items to it and then return that list
         */
        for(int i = 0; i < list.items.size();i++){
            if(list.items.get(i).getComplete().equals("false")){
                incomplete.add(list.items.get(i));
            }
        }
        return incomplete;
    }
    public ArrayList<Item> loadcomplete(ToDo list){
        ArrayList<Item> complete1 = new ArrayList<>();
        for(int i = 0; i < list.items.size();i++){
            if(list.items.get(i).getComplete().equals("true")){
                complete1.add(list.items.get(i));
            }
        }
        /*
        function will traverse through the ToDo list and
        add the complete items to it and then return that list
         */
        return complete1;
    }
}
