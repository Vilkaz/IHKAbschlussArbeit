package model.validation;

import model.sudokuFactory.Sudoku;
import model.sudokuFactory.SudokuField;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class ValidateCoherenceByOnlyOneValueInEachSet implements SudokuRule {

    @Override
    public void validate(Sudoku sudoku) {
        List<SudokuField> allFields = sudoku.getAllFields();
        for (SudokuField checkField : allFields) {
            for (Iterator<SudokuField> iterator = checkField.getLinkedFields().iterator();
                 iterator.hasNext(); ) {
                SudokuField linkedField = iterator.next();
                if (checkField.getValue() == linkedField.getValue()) {

                    iterator.remove();
                }
            }

        }
    }
}
