/*
        *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
        *  Copyright 2021 Logan Kilburn
*/
package baseline;

import javafx.beans.property.ObjectProperty;
import javafx.event.*;

import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.Array;

/*
Problem:
    The application shall be able to manage at least 256 unique todo lists

    A todo list shall have a title
    A title shall be at least 3 characters long
    A todo list shall have the capacity to store at least 256 unique items
    An item shall have a description
    An item shall have a due date, formatted as YYYY-MM-DD

    A user shall be able to add a new todo list
    A user shall be able to remove an existing todo list
    A user shall be able to edit the title of an existing todo list

    A user shall be able to add a new item to an existing todo list
    A user shall be able to remove an item from an existing todo list
    A user shall be able to edit the description of an item within an existing todo list
    A user shall be able to edit the due date of an item within an existing todo list
    A user shall be able to mark an item in a todo list as complete
    A user shall be able to display all of the existing items in a todo list
    A user shall be able to display only the incompleted items in a todo list
    A user shall be able to display only the completed items in a todo list
    A user shall be able to save todo lists to local storage
    A user shall select which lists will be saved
    A user shall specify the file location and name for the saved data
    All selected lists shall be saved to a single text file
    A user shall be able to load previously saved todo list data

Pseudocode:
    //Application
    When the application runs, open the Application.fxml GUI
    There are 3 different buttons to choose from on the screen, and each button should take the user to a different screen
    When the user presses the Add To Do List, it takes them to addToDoList.fxml
    When the user pressed the Delete To Do List, it takes them to choosoToDoList.fxml
    When the user presses the Edit To Do List, it takes them to editToDoList.fxml

    //addToDoList
    To add to a To Do List,
    Enter the title of the ToDoList
    Enter the description of the ToDoList
    Enter the Due Date of the To Do List, with a YYYY-MM-DD format
    Enter all the items of the To Do List
    Or
    Load the To Do List save data from a previously saved file
    return to the main application.fxml

    //choosoToDoList.fxml
    To delete a ToDoList,
    Choose a list to delete from the context menu
    Return to the application.fxml

    //editToDoList.fxml
    To edit the To Do List,
    The user has to select a To Do List to work with
    When the Add Item button is pressed, we will add an item to the To Do List by creating a pop up window that
    allows us to type in the description of the item to complete and when we close it out it saves the item
    When the Delete Item is pressed, we will delete an Item from the To Do List by going to chooseItem.fxml
    When the Edit Description button is pressed, we will open a text window to edit the description and once you close it,
    it saves the new description
    When the Display Items is pressed, will display the items in a new GUI using showItems.fxml
    When the Save To Do List button is pressed, it will save the to do list in the relative docs directory
    Once any of the buttons are clicked(except delete button and display Items), it will return the user to the main application.fxml

    //chooseItem.fxml
    Items will be displayed inside a context menu
    Select which item you want to be deleted
    Once an item is chosen, it will return you to the main Application.fxml

    //showItems.fxml
      Display all items in a text field
      In a drop down menu label as mark as complete, mark the item you want to complete
      When the button of Show Complete is pressed, it will show the completed items
      When the button of Show Incomplete is pressed, it will show the uncompleted items
      Click the return to start button to return to application.fxml
     */

public class Application extends javafx.application.Application implements EventHandler<ActionEvent> {

    public void printItem(item[] toDoListArray){
        //Print out the items in a To Do List
    }
    public void printCompleteItems(item[] toDoListArray){
        //prints only complete items
    }
    public void printIncompleteItems(item[] toDoListArray){
        //prints only incomplete items
    }
    public String getToDoListTitle(item[] toDoListArray){
        //returns the title of a To Do List
        return "";
    }
    public String getToDoListDescription(item[] toDoListArray){
        //returns Description of a To Do List
        return "";
    }
    public String getItemDescription(item[] toDoListArray){
        //returns Item Description at the item[index]
        return "";
    }
    public String getItemDueDate(item[] toDoListArray){
        //returns the items due date at the item[index]
        return "";
    }
    public boolean getItemComplete(item[] toDoListArray){
            //return whether the item is complete or not at the item[index]
        return (true || false);   //returns either true or false
    }
    public void setItemDescription(item[] toDoListArray, String input){
        //sets Item Description at the item[index]

    }
    public void setItemDueDate(item[] toDoListArray, String input){
        //sets the items due date at the item[index]

    }
    public void setItemComplete(item[] toDoListArray, String input){
        //sets whether the item is complete or not at the item[index]

    }
    public void saveToDoList(item[] toDoListArray){
        //this creates a .txt document that will be able to be saved on the local repository
    }
    public File loadToDoList(item[] toDoListArray){
        //returns a .txt file of a ToDoList that is on your local hardware
        File newFile = new File();
        return newFile;
    }



    public void addItem(item[] toDoListArray){
        //add an item to a list
        //set description of item index to the text in the description textField
        //set due date of item index to the text in the dueDate textField
        //set complete to false
    }
    public void removeItem(item[] toDoListArray){
        //delete item from to do list
        //set description of item index to empty
        //set due date of item index to empty
        //set complete of item index to false
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        //when program starts up, the screen should show the application.fxml


        addToDoListButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //run addToDoList method
            }
        });
        deleteToDoListButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //run deleteToDoList method
            }
        });
        editToDoListButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //switch to editToDoList.fxml
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //adds the to do list info to the list of to do lists
            }
        });
        addItemButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //opens a text box to type in the description of the item in the text box, and the due date underneath
            }
        });
        deleteItemButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //switches to chooseItem.fxml
            }
        });
        editDescriptionButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //puts the current description in a text box and allows you to make changes to it, and saves it once
                //user closes the box
            }
        });
        displayItems.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //switch to showItemsList.fxml
            }
        });
        saveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //run the saveToDoList method to save the to do list
            }
        });
        loadButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //switch to choosoToDoList.fxml
            }
        });

        //context menus should show all items in a to do list
        /*in addToDoList
            textFieldTitle is going to store toToList.title
            textFieldDescription is going to store toToList.description
        */

    }
}


