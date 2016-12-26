package model.sudoku.sudoku;

import model.sudoku.rules.SudokuRules;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuFieldTest {
    SudokuFactory factory = new SudokuFactory();

    @Test
    public void testRemoveLinkedFieldsByID() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField field = sudoku.getAllFields().get(0);
        List<SudokuField> linkedFields = field.getLinkedFields();
        assertEquals(80, linkedFields.size());
        int id = linkedFields.get(0).getId();
        field.removeLinkedFieldByID(id);
        assertEquals(79, field.getLinkedFields().size());
    }

    @Test
    public void getLinkedFieldsWithSameIDs() {
        SudokuField field1 = new SudokuField(1, 1);
        SudokuField field2 = new SudokuField(2, 2);
        SudokuField field3 = new SudokuField(3, 3);
        field1.getLinkedFields().add(field2);
        field1.getLinkedFields().add(field3);
        List linkedFields = field1.getLinkedFieldsWithSameIDs(field1);
        assertEquals(linkedFields.size(), field1.getLinkedFields().size());
    }


    @Test
    public void getAllLinkedFieldIDs() {
        SudokuField field1 = new SudokuField(1, 1);
        SudokuField field2 = new SudokuField(2, 2);
        SudokuField field3 = new SudokuField(3, 3);
        field1.getLinkedFields().add(field2);
        field1.getLinkedFields().add(field3);
        List linkedFieldsIDs = field1.getLinkedFieldsIDs();
        assertEquals(linkedFieldsIDs.size(), field1.getLinkedFields().size());
        for (int i = 0; i < linkedFieldsIDs.size(); i++) {
            assertEquals(linkedFieldsIDs.get(i), field1.getLinkedFields().get(i).getId());
        }
    }

    @Test
    public void testGetValueWith80LinkedFields() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField field = sudoku.getAllFields().get(0);
        field.setValue(0);
        field.calculateValue();
        assertEquals(0, field.getValue());
    }

    @Test
    public void testGetValueWith20LinkedFields() {
        Sudoku sudoku = factory.getSudoku();
        SudokuRules rules = new SudokuRules();
        rules.teachRules(sudoku);
        SudokuField field = sudoku.getAllFields().get(0);
        field.setValue(0);
        field.calculateValue();
        assertNotEquals(0, field.getValue());
        assertEquals(1, field.getPossibleValues().size());
    }

}