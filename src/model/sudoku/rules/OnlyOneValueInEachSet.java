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
        sudoku.copyValuesFrom(newSudoku);
        for (SudokuField checkField : sudoku.getAllFields()) {
            Iterator<SudokuField> iterator = checkField.getLinkedFields().iterator();
            while (iterator.hasNext()) {
                SudokuField field = iterator.next();
                if (field.getValue() == checkField.getValue()) {
                    iterator.remove();
                }
            }
        }
    }

    private List<SudokuField> getNewSudokuFields() {
        return sudokuFactory.getSudoku().getAllFields();
    }
}
