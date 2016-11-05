package model.sudoku;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.*;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuField {
    private int id;
    private int value;
    private List<SudokuField> linkedFields = new ArrayList<>();
    private Set<Integer> possibleValues;
    private SimpleStringProperty viewValue = new SimpleStringProperty();
    private SimpleStringProperty cssClass = new SimpleStringProperty();

    public String getViewValue() {
        return viewValue.get();
    }

    public SimpleStringProperty viewValueProperty() {
        if (value==0){
            viewValue.set("");
        } else {
            viewValue.set(String.valueOf(this.value));
        }
        return viewValue;
    }

    public SudokuField(int value) {
        this(-1,value);
    }

    public SudokuField(int id, int value) {
        this.id = id;
        this.value = value;
        initAllPosibleValues();
    }

    public void removeLinkedFieldByID(int id){
        Iterator<SudokuField> iterator = linkedFields.iterator();
        while (iterator.hasNext()){
            SudokuField field = iterator.next();
            if (field.getId()==id){
                iterator.remove();
            }
        }
    }



    public int getAmountOfLinkedFields(){
        return linkedFields.size();
    }


    public List<SudokuField> getLinkedFieldsWithSameIDs(SudokuField requestingField){
        List<SudokuField> fieldsWithSameID = new ArrayList<>();
        for (SudokuField field:requestingField.getLinkedFields()){
            fieldsWithSameID.add(getLinkedFieldByID(field.getId()));
        }
        return fieldsWithSameID;
    }

    public SudokuField getLinkedFieldByID(int id){
        for (SudokuField field:linkedFields){
            if (field.getId()==id){
                return field;
            }
        }
        return null;
    }



    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List<SudokuField> getLinkedFields() {
        return linkedFields;
    }




    public int getId() {
        return id;
    }

    public List getLinkedFieldsIDs() {
        List<Integer> ids = new ArrayList<>();
        for (SudokuField field : this.linkedFields){
            ids.add(field.getId());
        }
        return ids;
    }

    public void calculateValue() {
        initAllPosibleValues();
        for (SudokuField field :  linkedFields){
            possibleValues.remove(field.getValue());
        }
        if (possibleValues.size()==1){
            this.value=possibleValues.iterator().next();
            this.viewValueProperty().set(String.valueOf(this.value));
        }
    }

    private void initAllPosibleValues(){
        this.possibleValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }

    public String getCssClass() {
        return cssClass.get();
    }

    public SimpleStringProperty cssClassProperty() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass.set(cssClass);
    }
}
