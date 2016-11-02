package model.sudoku;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by vkukanauskas on 27/10/2016.
 */

public class SudokuFactoryTest {

    SudokuFactory sudokuFactory = new SudokuFactory();
    private Sudoku sudoku = sudokuFactory.getSudoku();
    NineSets vertical = sudoku.getVerticalLines();
    NineSets horizontal = sudoku.getVerticalLines();
    NineSets cubics = sudoku.getVerticalLines();

    @Test
    public void testGetSudoku() {
        assertTrue(sudoku instanceof Sudoku);
    }

    @Test
    public void testGettingSudokuSets() {
        assertTrue(vertical instanceof NineSets);
        assertTrue(horizontal instanceof NineSets);
        assertTrue(cubics instanceof NineSets);
    }

    @Test
    public void testGet9UniqueNumbersInRandomOrder() {
        List<Integer> uniqueNumbers = sudokuFactory.get9UniqueNumbersInRandomOrder();
        Collections.sort(uniqueNumbers);
        for (int i = 1; i <= 9; i++) {
            assertEquals(i, (int) uniqueNumbers.get(i - 1));
        }
    }


    @Test
    public void testSetFieldAmount() {
        assertTrue(vertical.getSets().size() == 9);
        assertTrue(horizontal.getSets().size() == 9);
        assertTrue(cubics.getSets().size() == 9);
    }

    @Test
    public void testOneSpecificFieldTemTimes(){
        for (int i=0;i<10;i++){
            Sudoku sudoku = sudokuFactory.getSudoku();
            assertTrue(testBottomRightFieldOfFirstCubic(sudoku));
        }
    }

    private boolean testBottomRightFieldOfFirstCubic(Sudoku sudoku) {
        int verticalValue = sudoku.getVerticalLines().get(2).get(2).getValue();
        int horizontalValue = sudoku.getHorizontalLines().get(2).get(2).getValue();
        int cubeValue = sudoku.getCubics().get(0).get(8).getValue();
        return (verticalValue == horizontalValue) && (verticalValue == cubeValue);
    }

}