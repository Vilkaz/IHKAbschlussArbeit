package model.sudoku.sudoku;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class NineFieldsTest {
    @Test
    public void testContains(){
        NineFields nineFields = new NineFields();
        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = new SudokuField(2);
        SudokuField field3 = new SudokuField(3);
        SudokuField field4 = new SudokuField(4);
        SudokuField field5 = new SudokuField(5);
        nineFields.getFields().add(field1);
        nineFields.getFields().add(field2);
        nineFields.getFields().add(field3);
        nineFields.getFields().add(field4);
        nineFields.getFields().add(field5);
        assertTrue(nineFields.contains(1));
        assertTrue(nineFields.contains(2));
        assertTrue(nineFields.contains(3));
        assertTrue(nineFields.contains(4));
        assertTrue(nineFields.contains(5));
        assertFalse(nineFields.contains(6));
        assertFalse(nineFields.contains(7));
        assertFalse(nineFields.contains(8));
        assertFalse(nineFields.contains(9));
    }

}