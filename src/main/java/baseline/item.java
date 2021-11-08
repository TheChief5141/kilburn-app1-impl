package baseline;

import java.time.LocalDate;

public class item{
    Integer index;
    String description;
    LocalDate dueDate;
    boolean complete;

    public static item addItem(int itemindex, LocalDate dueDate, String description, boolean completed){
        item newIndex = new item();
        newIndex.index = itemindex;
        newIndex.dueDate = dueDate;
        newIndex.description = description;
        newIndex.complete = completed;
        return newIndex;
    }

    public Integer getIndex(){
        return index;
    }

    public String getDescription(){
        return description;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public boolean getComplete(){
        return complete;
    }
}