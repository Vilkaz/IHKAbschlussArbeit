package model.sudoku;

import java.util.*;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuField {
    private int id;
    private int value;
    private List<SudokuField> linkedFields = new ArrayList<>();
    private Set<Integer> possibleValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));


    public SudokuField(int value) {
        this.value = value;
    }

    public SudokuField(int id, int value) {
        this.id = id;
        this.value = value;
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
        for (SudokuField field :  linkedFields){
            possibleValues.remove(field.getValue());
        }
        if (possibleValues.size()==1){
            this.value=possibleValues.iterator().next();
        }
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }
}