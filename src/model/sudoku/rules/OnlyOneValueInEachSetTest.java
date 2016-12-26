package model.sudoku.rules;

import model.sudoku.sudoku.Sudoku;
import model.sudoku.sudoku.SudokuFactory;
import model.sudoku.sudoku.SudokuField;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class OnlyOneValueInEachSetTest {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Test
    public void validateLength()  {
        Sudoku sudoku = sudokuFactory.getSudoku();
        SudokuRules sudokuRules = new SudokuRules();
        sudokuRules.teachRules(sudoku);
        Collection linkedFields = sudoku.getAllFields().get(0).getLinkedFields();
        assertEquals(20, linkedFields.size());
    }

    @Test
    public void validateEachLinkedField(){
        Sudoku sudoku = sudokuFactory.getSudoku();
        SudokuRules validator = new SudokuRules();
        validator.teachRules(sudoku);
        SudokuField field = sudoku.getAllFields().get(0);
        for (SudokuField linkedField:field.getLinkedFields()){
            assertNotEquals(field.getValue(), linkedField.getValue());
        }

    }

}