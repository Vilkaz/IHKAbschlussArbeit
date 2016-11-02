package model.sudoku;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuTest {
    SudokuFactory factory = new SudokuFactory();

    @Test
    public void testGetAllFields() throws Exception {
        Sudoku sudoku = factory.getSudoku();
        List<SudokuField> allFields = sudoku.getAllFields();
        assertTrue(allFields.size() == 81);
    }

    @Test
    public void testGetCubicleNumber() throws Exception {
        Sudoku sudoku = factory.getSudoku();
        assertEquals(sudoku.getCubicleNumber(0, 0), 0);
        assertEquals(sudoku.getCubicleNumber(8, 8), 8);
        assertEquals(sudoku.getCubicleNumber(3, 0), 3);
        assertEquals(sudoku.getCubicleNumber(3, 4), 4);
        assertEquals(sudoku.getCubicleNumber(6, 0), 6);
        assertEquals(sudoku.getCubicleNumber(6, 4), 7);
    }


    /**
     * it is important, that not only Values are the same, but that
     * the Fields in different Objects are realy same Objects on stash !
     */
    @Test
    public void testIsTopLeftFieldSameObjectInAllLists() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField verticalField = sudoku.getVerticalLines().get(0).get(0);
        SudokuField horizontalField = sudoku.getHorizontalLines().get(0).get(0);
        SudokuField cubicField = sudoku.getCubics().get(0).get(0);
        assertTrue(verticalField == horizontalField);
        assertTrue(horizontalField == cubicField);
    }

    @Test
    public void testIsBottomRightFieldSameObjectInAllLists() {
        Sudoku sudoku = factory.getSudoku();
        SudokuField verticalField = sudoku.getVerticalLines().get(8).get(8);
        SudokuField horizontalField = sudoku.getHorizontalLines().get(8).get(8);
        SudokuField cubicField = sudoku.getCubics().get(8).get(8);
        assertTrue(verticalField == horizontalField);
        assertTrue(horizontalField == cubicField);
    }




    @Test
    public void testLinkedFieldSizeInFreshSudoku() {
        Sudoku sudoku = factory.getSudoku();
        for (SudokuField field : sudoku.getAllFields()) {
            Collection<SudokuField> list = field.getLinkedFields();
            assertEquals(80, field.getLinkedFields().size());
        }
    }

    @Test
    public void testSudokuFor9x9Values() {
        Sudoku sudoku = factory.getSudoku();
        List<Integer>[] values = new List[9];
        int i = 0;
        for (SudokuField field : sudoku.getAllFields()) {
            int fieldValue = field.getValue();
            int arrayIndex = fieldValue-1;
            if (values[arrayIndex] == null) {
                values[arrayIndex] = new ArrayList<>();
            }
            values[arrayIndex].add(i);
            i++;
        }
        for (List<Integer> valueList :  values){
            assertEquals(9,valueList.size());
        }

    }

}