package model.sudokuGenerator;

import java.util.*;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuField{
    private int value;
    private Collection<SudokuField> linkedFields;
    private Set possibleValues = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public SudokuField(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public Collection getLinkedFields() {
        return linkedFields;
    }

    public Collection getPossibleValues() {
        return possibleValues;
    }
}
