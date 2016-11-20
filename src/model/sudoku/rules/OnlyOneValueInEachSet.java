package model.sudoku.rules;

import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.SudokuField;

import java.util.Iterator;
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
        for (SudokuField field : sudoku.getAllFields()) {
            removeLinkedFieldsWithSameValueAsCheckedField(field);
        }
    }

    private void removeLinkedFieldsWithSameValueAsCheckedField(SudokuField field) {
        Iterator<SudokuField> iterator = field.getLinkedFields().iterator();
        while (iterator.hasNext()) {
            SudokuField linkedField = iterator.next();
            if (linkedField.getValue() == field.getValue()) {
                iterator.remove();
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
