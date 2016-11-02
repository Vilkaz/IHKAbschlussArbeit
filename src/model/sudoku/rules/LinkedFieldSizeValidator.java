package model.sudoku.rules;

import model.sudoku.SudokuField;

import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class LinkedFieldSizeValidator {
    public static boolean areAllFieldsValide(List<SudokuField> fields) {
        for (SudokuField field : fields) {
            if (field.getLinkedFields().size() != 20) {
                return false;
            }
        }
        return true;
    }

}
