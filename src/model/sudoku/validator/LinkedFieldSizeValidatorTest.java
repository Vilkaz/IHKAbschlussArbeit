package model.sudoku.validator;

import model.sudoku.SudokuField;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class LinkedFieldSizeValidatorTest {
    @Test
    public void testInvalidFields() {
        SudokuField field1 = new SudokuField(1);
        SudokuField field2 = new SudokuField(2);
        SudokuField field3 = new SudokuField(3);
        List list = new ArrayList<>(Arrays.asList(field1, field2, field3));
        assertFalse(LinkedFieldSizeValidator.areAllFieldsValide(list));
    }

    @Test
    public void testValidFields() {
        List list = new ArrayList<>();
        for (int i=0;i<20;i++){
            SudokuField field = new SudokuField(i,i);
            list.add(field);
        }
        SudokuField field2 = new SudokuField(2);
        field2.getLinkedFields().addAll(list);
        List list2 = new ArrayList(Arrays.asList(field2));
        assertTrue(LinkedFieldSizeValidator.areAllFieldsValide(list2));
    }



}