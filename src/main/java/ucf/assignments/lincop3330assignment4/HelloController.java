package ucf.assignments.lincop3330assignment4;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
import java.util.*;
import java.io.*;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import ucf.assignments.Item;
import ucf.assignments.ToDo;

public class HelloController{
    @FXML
    private TableView<String> options;
    @FXML
    private Label welcomeText;
    @FXML
    private VBox box;
    @FXML
    private Label listName;
    @FXML
    private TextField field;
    @FXML
    private Button submitbutton;
    @FXML
    private Button uploadList;
    @FXML
    private TableColumn<Item, String> complete;
    @FXML
    private TableColumn<Item, String> task;
    @FXML
    private TableColumn<Item, String> date;
    @FXML
    private TableView<String> listTable;
    @FXML
    private Button finish;
    @FXML
    private TextField taskField;
    @FXML
    private Label taskLabel;
    @FXML
    private HBox listBox;
    @FXML
    private Button hello;

    //This will manage all the ToDo Lists
    //ArrayList<ToDo> masterList = new ArrayList<>();

    @FXML
    protected void onHelloButtonClick(){
        /*
        This will prompt the user to create a new list
        asking for the list name first
         */
        listName.setVisible(true);
        field.setVisible(true);
        submitbutton.setVisible(true);
        uploadList.setVisible(false);
        hello.setVisible(false);
    }
    @FXML
    protected void OnButtonClick(){
        //listTable.setVisible(true);
        //for(int i = 0; i < masterList.size();i++){
            //complete.setCellValueFactory(new PropertyValueFactory<>());

        //options.setText("Select a List");
        //options.setVisibility(true);
        /*
            add each element in arraylist to the list
            Purpose of this function is to display the lists already in existence
        */
    }
    @FXML
    protected void onSubmitClick(){
        //this function is to add the elements to the list
        /*this function also will utilize the function in the
        todo class to upload to a .csv file
         */
    }
    @FXML
    protected void onFinishClick(){
        /*
        purpose of this function is to finish adding to a certain list
        and afterwards list is finished displaying a finished list
        this function is to end the addition of more items to the list
         */
    }
    @FXML
    protected void onHelpClick(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("help.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Help");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (Exception e){
            System.out.println("not working");
        }
    }
}
