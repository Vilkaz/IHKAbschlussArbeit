package model.validation;

import model.sudokuFactory.Sudoku;
import model.sudokuFactory.SudokuFactory;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class ValidateCoherenceByOnlyOneValueInEachSetTest {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Test
    public void validate()  {
        Sudoku sudoku = sudokuFactory.getSudoku();
        SudokuValidator validator = new SudokuValidator();
        validator.validate(sudoku);
        Collection linkedFields = sudoku.getAllFields().get(0).getLinkedFields();
        assertEquals(72, linkedFields.size());
    }

}