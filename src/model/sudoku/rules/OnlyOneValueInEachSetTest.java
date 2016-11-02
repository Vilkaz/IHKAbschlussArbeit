package model.sudoku.rules;

import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class OnlyOneValueInEachSetTest {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Test
    public void validate()  {
        Sudoku sudoku = sudokuFactory.getSudoku();
        SudokuRules validator = new SudokuRules();
        validator.learnRules(sudoku);
        Collection linkedFields = sudoku.getAllFields().get(0).getLinkedFields();
        assertEquals(20, linkedFields.size());
    }

}