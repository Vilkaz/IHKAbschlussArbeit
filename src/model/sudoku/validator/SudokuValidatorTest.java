package model.sudoku.validator;

import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.SudokuField;
import model.sudoku.rules.SudokuRule;
import model.sudoku.rules.SudokuRules;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 02/11/2016.
 */
public class SudokuValidatorTest {
    SudokuFactory factory = new SudokuFactory();
    SudokuValidator validator = new SudokuValidator();
    SudokuRules rules = new SudokuRules();

    @Test
    public void testSolveSudokuWithOneEmptyField() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField field = sudoku.getAllFields().get(0);
        field.setValue(0);
        assertFalse(validator.isValid(sudoku));
        rules.learnRules(sudoku);
        field.calculateValue();
        assertTrue(validator.isValid(sudoku));
    }

    @Test
    public void testSolveSudokuWithTwiIdenticalValuesInSameSet() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField field1 = sudoku.getAllFields().get(0);
        SudokuField field2 = sudoku.getAllFields().get(1);
        field1.setValue(1);
        field2.setValue(1);
        assertFalse(validator.isValid(sudoku));
    }



}