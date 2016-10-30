//package model.sudokuGenerator;
//
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by vkukanauskas on 27/10/2016.
// */
//
//public class SudokuGeneratorTest {
//
//    private SudokuDTO sudoku = new SudokuGenerator().getSudoku();
//    NineSets vertical = sudoku.getVerticalLines();
//    NineSets horizontal = sudoku.getVerticalLines();
//    NineSets cubics = sudoku.getVerticalLines();
//
//    @Test
//    public void testGetSudoku() {
//        assertTrue(sudoku instanceof SudokuDTO);
//    }
//
//    @Test
//    public void testGettingSudokuSets() {
//        assertTrue(vertical instanceof NineSets);
//        assertTrue(horizontal instanceof NineSets);
//        assertTrue(cubics instanceof NineSets);
//    }
//
//    @Test
//    public void testSetFieldAmount() {
//        assertTrue(vertical.getFields().length == 9);
//        assertTrue(horizontal.getFields().length == 9);
//        assertTrue(cubics.getFields().length == 9);
//    }
//
//    @Test
//    public void test9NoEmtyValuesInSets() {
//        boolean valid = (hasValidValues(vertical) &&
//                hasValidValues(horizontal) &&
//                hasValidValues(cubics));
//        assertTrue(valid);
//
//    }
//
//    private boolean hasValidValues(NineSets set) {
//        boolean valid = true;
//        for (int i = 0; i < 9; i++) {
//            SudokuField field = set.getFields()[i];
//            if (field == null) {
//                valid = false;
//            } else {
//                if (field.getValue() < 1 || field.getValue() > 9) {
//                    valid = false;
//                }
//            }
//        }
//        return valid;
//    }
//
//}