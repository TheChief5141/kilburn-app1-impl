package baseline;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/*
PseudoCode:
when application starts, the APPLICATION_2 should open

when the application opens, there is a menu list at the top of the screen
There is file, where you can save and load to do lists
There is edit, where you can add, delete and edit items
There is view, where you can view completed items, incomplete items, and view all items
ANd a help section, which plays a video about how to use the application

The Save Button will open up a file explorer window to save your file
The Load Button will open up a file explorer window to load your .txt file into the app

The add button will show the add button field, where you can put info into the designated boxes,
and when you click on the add items button, the items in the text field will go to the table
The delete button will show the delete item field, where you choose which item to delete
in a context menu and you delete the item by clicking on the delete item button
The edit button will show the edit item field, where you can choose an item from a context menu,
and then put in the information you want to change about the item, and when you click on the edit item button,
the item info will change in the table

All items will be displayed in the table view constantly, and will show the items description,
the items due date, and whether the item has been marked complete or not
Items will be stored in an observable array list of items

In the view section, when clicked on the view all items button,
it will show all the items in the to do list
when the view completed items button is clicked, it will only show
the completed items
when the view incompleted items button is clicked, it will only show
the incompleted items

 */


public class TodoListApplication extends Application {
    ArrayList<item> ToDoList = new ArrayList<>();
    ObservableList<item> theToDoList = FXCollections.observableArrayList(ToDoList);

    public static void main(String[] args) {
        launch(args);
        //when the application starts


    }

    //menuBar
    @FXML
    MenuBar menuApp;
    @FXML
    Menu fileMenu;
    @FXML
    Menu editMenu;
    @FXML
    Menu viewMenu;
    @FXML
    Menu helpMenu;

    //menu items
    @FXML
    MenuItem saveButton;
    @FXML
    MenuItem loadButton;
    @FXML
    MenuItem addItemButton;
    @FXML
    MenuItem deleteItemButton;
    @FXML
    MenuItem editButton;
    @FXML
    MenuItem viewCompleteButton;
    @FXML
    MenuItem viewIncompleteButton;
    @FXML
    MenuItem viewAllButton;
    @FXML
    MenuItem aboutButton;

    //TableView
    @FXML
    TableView<item> theTable = new TableView<>(FXCollections.observableArrayList(ToDoList));
    @FXML
    TableColumn<item, Integer> itemIndex;
    @FXML
    TableColumn<item, Boolean> itemCompleted;
    @FXML
    TableColumn<item, String> itemDueDate;
    @FXML
    TableColumn<item, String> itemDescription;

    //addItemField
    @FXML
    HBox addItemField;
    @FXML
    TextField addItemDescription;
    @FXML
    DatePicker itemDueDatePicker;
    @FXML
    Button addItemIntoTableButton;
    @FXML
    CheckBox completeCheckBox;

    //deleteItemField
    @FXML
    HBox deleteItemField;
    @FXML
    ComboBox<item> itemChooser = new ComboBox<>(FXCollections.observableArrayList(ToDoList));
    @FXML
    Button deleteItemForGoodButton;

    //editItemField
    @FXML
    HBox editItemField;
    @FXML
    ComboBox<item> itemChooser1 = new ComboBox<>(FXCollections.observableArrayList(ToDoList));
    @FXML
    TextField addItemDescription1;
    @FXML
    DatePicker itemDueDatePicker1;
    @FXML
    CheckBox completeCheckBox1;
    @FXML
    Button editItemForGoodButton;





    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("javafx/newApplication.fxml")));
        primaryStage.setTitle("To Do List Application");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();



    }

    public void showDeleteField(ActionEvent actionEvent) {
        //turn the hboxDeleteField visible
        deleteItemField.setVisible(true);
    }

    public void showEditField(ActionEvent actionEvent) {
        //turn the hboxEditField visible
        editItemField.setVisible(true);
    }

    public void showAddField(ActionEvent actionEvent) {
        //turn the hboxAddField visible
        addItemField.setVisible(true);
    }

    public void loadToDoList(ActionEvent actionEvent) throws IOException {
        //open file explorer and parse a  .txt file to store in the arrayList
        try {
            Process builder = Runtime.getRuntime().exec("cmd /c start C:/ProgramData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToDoList(ActionEvent actionEvent) throws IOException {
        //save the todolist as a .txt file and open up file explorer

        FileWriter writer = new FileWriter("output.txt");
        for(item str: ToDoList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public void viewCompletedItems(ActionEvent actionEvent) {
        //print only completed items in the tableview
        for(int i = 0; i <= ToDoList.size(); i++){
            if(ToDoList.get(i).complete){
                itemIndex.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<item, Integer>, ObservableValue<Integer>>() {
                    public ObservableValue<Integer> call(TableColumn.CellDataFeatures<item, Integer> p) {
                        return new ReadOnlyObjectWrapper<>(p.getValue().getIndex());
                    }
                });
                theTable.getColumns().add(itemIndex);
            }
        }

    }

    public void viewIncompletedItems(ActionEvent actionEvent) {
        //print only incompleted items in the tableview
        for(int i = 0; i <= ToDoList.size(); i++){
            if(!(ToDoList.get(i).complete)){
                itemIndex.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<item, Integer>, ObservableValue<Integer>>() {
                    public ObservableValue<Integer> call(TableColumn.CellDataFeatures<item, Integer> p) {
                        return new ReadOnlyObjectWrapper<>(p.getValue().getIndex());
                    }
                });
                theTable.getColumns().add(itemIndex);
            }
        }
    }

    public void viewAllItems(ActionEvent actionEvent) {
        //print all items in todolist in the tableview
        itemIndex.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<item, Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<item, Integer> p) {
                return new ReadOnlyObjectWrapper<>(p.getValue().getIndex());
            }
        });
        theTable.getColumns().add(itemIndex);

    }

    public void playVideo(ActionEvent actionEvent) {
    }

    public void addItemToDoList(ActionEvent actionEvent) {
        //store text box info into item description
        // store date picker info into item due date
        ToDoList.add(ToDoList.size(), item.addItem(ToDoList.size(), itemDueDatePicker.getValue(), addItemDescription.getText(), completeCheckBox.isSelected()));
        //make hboxAddField invisible
        addItemField.setVisible(false);
    }

    public void deleteItemToDoList(ActionEvent actionEvent) {
        //delete item description at index
        //delete item due date at index
        ToDoList.remove(itemChooser.getValue().index);
        //make hboxDeleteField invisible
        deleteItemField.setVisible(false);
    }

    public void editItemToDoList(ActionEvent actionEvent) {
        //change item description in chosen item index by grabbing text box info
        //change item due date in chosen item index by grabbing date picker info
        ToDoList.set(itemChooser1.getValue().index, item.addItem(ToDoList.size(), itemDueDatePicker1.getValue(), addItemDescription1.getText(), completeCheckBox1.isSelected()));
        //make hboxEditField invisible
        editItemField.setVisible(false);
    }
}
