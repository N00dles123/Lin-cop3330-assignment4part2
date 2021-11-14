package ucf.assignments.lincop3330assignment4;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
import java.text.ParseException;
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
    private HBox box1;
    @FXML
    private TableView<Item> options;
    @FXML
    private Button toList;
    @FXML
    private Button changestatus;
    @FXML
    private HBox box2;
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
    @FXML
    private Button delete;
    @FXML
    private Button changeDate;
    @FXML
    private Button nuke;
    @FXML
    private Button update;
    @FXML
    private Label dateLabel;
    @FXML
    private Button dueDate;
    @FXML
    private Button incomplete;
    @FXML
    private Button normal;
    @FXML
    private Button complete1;
    ToDo list = new ToDo();
    ObservableList<Item> items = FXCollections.observableArrayList();
    File f;
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
        list.clear();
        items.clear();
        options.getItems().clear();
        FileChooser file = new FileChooser();
        file.getExtensionFilters().add(new ExtensionFilter(".txt Files", "*.txt"));
        file.setTitle("Open File");
        file.setInitialDirectory(new File("src\\main\\java\\ucf\\assignments\\lists"));
        f = file.showOpenDialog(null);
        if(f.exists()){
            list.loadList(f);
            complete.setCellValueFactory(new PropertyValueFactory<>("complete"));
            task.setCellValueFactory(new PropertyValueFactory<>("description"));
            date.setCellValueFactory(new PropertyValueFactory<>("time"));
            for (int i = 0; i < list.getItems().size(); i++) {
                items.add(list.getItems().get(i));
            }
            options.setItems(items);
            listBox.setVisible(true);
            hello.setVisible(false);
            finish.setVisible(true);
            uploadList.setVisible(false);
        }
    }
    @FXML
    protected void onSubmitClick(){
        //this function is to add the elements to the list
        /*this function also will utilize the function in the
        todo class to upload to a .txt file
         */
        if(!(field.getText().isEmpty())) {
            list.changeTitle(field.getText());
            listBox.setVisible(true);
            finish.setVisible(true);
            field.clear();
            box2.setVisible(false);
        }

    }
    @FXML
    protected void onFinishClick(){
        /*
        purpose of this function is to finish adding to a certain list
        and afterwards list is finished displaying a finished list
        this function is to end the addition of more items to the list
         */
        list.saveList();
        uploadList.setVisible(true);
        finish.setVisible(false);
        listBox.setVisible(false);
        hello.setVisible(true);
        list.clear();
        items.clear();
        options.getItems().clear();
        list.changeTitle("");
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
    protected void addToListClick() throws ParseException {
        complete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        task.setCellValueFactory(new PropertyValueFactory<>("description"));
        date.setCellValueFactory(new PropertyValueFactory<>("time"));
        if(datePicker.getValue() != null) {
            if(!(taskField.getText().isEmpty())){
                String day = datePicker.getValue().toString();
                System.out.println(day);
                String task = taskField.getText();
                list.addItem(new Item(task,day));
                datePicker.setValue(null);
                taskField.clear();
                items.add(list.getItems().get(list.getItems().size()-1));
                options.setItems(items);
                options.refresh();
            }
        }

    }
    @FXML
    protected void onDeleteClick(){
        if(options.getSelectionModel().getSelectedItem() != null){
            list.removeItem(options.getSelectionModel().getSelectedItem().getDescription());
            items.remove(options.getSelectionModel().getSelectedItem());
        }
    }
    @FXML
    protected void onStatusClick(){
        if(options.getSelectionModel().getSelectedItem() != null){
            if(options.getSelectionModel().getSelectedItem().getComplete().equals("false")){
                list.findItem(options.getSelectionModel().getSelectedItem().getDescription()).setComplete();
                options.getSelectionModel().getSelectedItem().setComplete();
            }
            else if(options.getSelectionModel().getSelectedItem().getComplete().equals("true")){
                list.findItem(options.getSelectionModel().getSelectedItem().getDescription()).setIncomplete();
                options.getSelectionModel().getSelectedItem().setIncomplete();
            }
            options.refresh();
        }
    }
    @FXML
    protected void deleteList(){
        list.clear();
        items.clear();
        options.refresh();
        list.saveList();
        hello.setVisible(true);
        finish.setVisible(false);
        uploadList.setVisible(true);
        listBox.setVisible(false);
    }
    Item ofList = null;
    @FXML
    protected void changeDate(){
        if(options.getSelectionModel().getSelectedItem() != null){
            ofList = options.getSelectionModel().getSelectedItem();
            listBox.setVisible(true);
            taskField.setVisible(false);
            taskLabel.setVisible(false);
            toList.setVisible(false);
            changeDate.setVisible(true);
            delete.setVisible(false);
            changestatus.setVisible(false);
            nuke.setVisible(false);
            update.setVisible(false);

        }
    }
    @FXML
    protected void onChangeDate() throws ParseException {
        if(datePicker.getValue() != null) {
            list.findItem(ofList.getDescription()).setTime(datePicker.getValue().toString());
            ofList.setTime(datePicker.getValue().toString());
            datePicker.setValue(null);
            changeDate.setVisible(false);
            taskField.setVisible(true);
            taskLabel.setVisible(false);
            toList.setVisible(true);
            listBox.setVisible(false);
            changestatus.setVisible(true);
            delete.setVisible(true);
            nuke.setVisible(true);
            options.refresh();
        }
    }
    @FXML
    protected void onChangeDescClick(){
        if(options.getSelectionModel().getSelectedItem() != null){
            ofList = options.getSelectionModel().getSelectedItem();
            listBox.setVisible(true);
            taskLabel.setVisible(false);
            toList.setVisible(false);
            changeDate.setVisible(false);
            dueDate.setVisible(false);
            delete.setVisible(false);
            changestatus.setVisible(false);
            nuke.setVisible(false);
            datePicker.setVisible(false);
            dateLabel.setVisible(false);
            update.setVisible(true);
        }
    }

    @FXML
    protected void updateDesc(){
        if(!(taskField.getText().isEmpty())) {
            list.findItem(ofList.getDescription()).setDescription(taskField.getText());
            ofList.setDescription(taskField.getText());
            taskField.clear();
            changeDate.setVisible(false);
            delete.setVisible(true);
            dueDate.setVisible(true);
            taskLabel.setVisible(true);
            toList.setVisible(true);
            dateLabel.setVisible(true);
            datePicker.setVisible(true);
            nuke.setVisible(true);
            changestatus.setVisible(true);
            update.setVisible(false);
            listBox.setVisible(false);
            options.refresh();
        }
    }
    @FXML
    protected void onNormalClick(){
        box1.setVisible(true);
        items.clear();
        for(int x = 0; x < list.getItems().size(); x++) {
            items.add(list.getItems().get(x));
        }
        normal.setVisible(false);
        options.refresh();
    }
    @FXML
    protected void onincompleteClick(){
        if(list.getTitle() != "") {
            box1.setVisible(false);
            normal.setVisible(true);
            ArrayList<Item> notDone = list.loadincomplete(list);
            items.clear();
            for (int x = 0; x < notDone.size(); x++) {
                items.add(notDone.get(x));
            }
            options.refresh();
        }
    }
    @FXML
    protected void oncompleteClick(){
        if(list.getTitle() != "") {
            box1.setVisible(false);
            normal.setVisible(true);
            items.clear();
            ArrayList<Item> done = list.loadcomplete(list);
            for (int x = 0; x < done.size(); x++) {
                items.add(done.get(x));
            }
            options.refresh();
        }
    }
}
