package ucf.assignments.lincop3330assignment4;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
import java.time.LocalDate;
import java.util.*;
import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.FileChooser.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ucf.assignments.Item;
import ucf.assignments.ToDo;

public class HelloController{
    @FXML
    private TableView<Item> options;
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
    private TableColumn<Item, Boolean> complete;
    @FXML
    private TableColumn<Item, String> task;
    @FXML
    private TableColumn<Item, LocalDate> date;
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
    @FXML
    private VBox box3;
    @FXML
    private DatePicker datePicker;

    //This will manage all the ToDo Lists
    //ToDo masterList = new ArrayList<>();
    ToDo list;
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
        FileChooser file = new FileChooser();
        file.getExtensionFilters().add(new ExtensionFilter(".txt Files", "*.txt"));
        file.setTitle("Open File");
        file.setInitialDirectory(new File("src\\main\\java\\ucf\\assignments"));
        File f = file.showOpenDialog(null);
        list = new ToDo();
        list.loadList(f);
        ObservableList<Item> items = FXCollections.observableArrayList();
        complete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        task.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("time"));
        for(int i = 0; i < list.getItems().size(); i++) {
            items.add(list.getItems().get(i));
        }
        options.setItems(items);
        listBox.setVisible(true);
        hello.setVisible(false);
        finish.setVisible(true);
    }
    @FXML
    protected void onSubmitClick(){
        //this function is to add the elements to the list
        /*this function also will utilize the function in the
        todo class to upload to a .txt file
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
    @FXML
    protected void addToListClick(){
        if(datePicker.hasProperties()) {
            if(taskField.hasProperties()){
                //Date
                //list.addItem();
            }
        }
    }
}
