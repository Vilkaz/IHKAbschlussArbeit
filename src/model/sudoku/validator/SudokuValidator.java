package model.sudoku.validator;

import model.sudoku.sudoku.NineFields;
import model.sudoku.sudoku.NineSets;
import model.sudoku.sudoku.Sudoku;
import model.sudoku.sudoku.SudokuField;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Vilkas on 02/11/2016.
 */
public class SudokuValidator {
    private boolean valide = true;

    public boolean isValid(Sudoku sudoku) {
        List<SudokuField> fields = sudoku.getAllFields();
        checkAmountOfFields(fields);
        checkAlFieldsForValidValue(fields);
        checkAllSetsForUniqueValues(sudoku);
        return valide;
    }

    private void checkAllSetsForUniqueValues(Sudoku sudoku) {
        checkNineSetForDuplicates(sudoku.getVerticalLines());
        checkNineSetForDuplicates(sudoku.getHorizontalLines());
        checkNineSetForDuplicates(sudoku.getCubes());
    }

    private void checkNineSetForDuplicates(NineSets nineSets) {
        for (NineFields fields : nineSets.getSets()) {
            HashSet values = new HashSet();
            for (SudokuField field : fields.getFields()) {
                values.add(field.getValue());
            }
            if (values.size() != 9) {
                this.valide = false;
            }
        }
    }

    private void checkAlFieldsForValidValue(List<SudokuField> fields) {
        for (SudokuField field : fields) {
            if (field.getValue() <= 0) {
                valide = false;
            }
        }
    }

    private void checkAmountOfFields(List<SudokuField> fields) {
        this.valide = (fields.size() == 81);
    }
}
