package model.sudoku.rules;

import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.SudokuField;

import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class OnlyOneValueInEachSet implements SudokuRule {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Override
    public void implementRule(Sudoku sudoku) {
        Sudoku newSudoku = sudokuFactory.getSudoku();
        Sudoku backup = makeBackup(sudoku);
        sudoku.copyValuesFrom(newSudoku);
        removeFieldsWithSameValuesFromTheirLinkedLists(sudoku);
        restoreBackup(sudoku, backup);
    }

    private Sudoku makeBackup(Sudoku sudoku) {
        Sudoku backup = sudokuFactory.getEmptySudokuModel();
        backup.copyValuesFrom(sudoku);
        return backup;
    }

    private void removeFieldsWithSameValuesFromTheirLinkedLists(Sudoku sudoku) {
        List<SudokuField> fields = sudoku.getAllFields();
        for (int outerCounter = 0; outerCounter < sudoku.getAllFields().size(); outerCounter++) {
            {
                SudokuField field = fields.get(outerCounter);
                removeLinkedFieldsWithSameValueAsCheckField(field);
            }
        }
    }

    private void removeLinkedFieldsWithSameValueAsCheckField(SudokuField field) {
        List<Integer> linkedFieldsIDs = field.getLinkedFieldsIDs();
        for (int i : linkedFieldsIDs) {
            SudokuField linkedField = field.getLinkedFieldByID(i);
            if (linkedField.getValue() == field.getValue()) {
                field.removeLinkedFieldByID(i);
            }
        }
    }

    private void restoreBackup(Sudoku sudoku, Sudoku backup) {
        sudoku.copyValuesFrom(backup);
    }



    private List<SudokuField> getNewSudokuFields() {
        return sudokuFactory.getSudoku().getAllFields();
    }
}
