package model.sudokuFactory;

import java.util.*;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuField{
    private int value;
    private Collection<SudokuField> linkedFields = new ArrayList<>();
    private Set possibleValues = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public SudokuField(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public Collection<SudokuField> getLinkedFields() {
        return linkedFields;
    }

    public Collection getPossibleValues() {
        return possibleValues;
    }
}
