package model.sudoku.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuFactory {
    private Sudoku sudoku;
    private int validFields;

    public Sudoku getSudoku() {
        do {
            validFields = 0;
            sudoku = new Sudoku(new NineSets(), new NineSets(), new NineSets());
            initial:
            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                    int trys = 0;
                    for (int number : getNineUniqueNumbersInRandomOrder()) {
                        if (numberIsUnique(row, column, number)) {
                            insertNumberIntoSudoku(row, column, number);
                            validFields++;
                            break;
                        } else {
                            trys++;
                        }
                        if (trys == 9) break initial;
                    }
                }
            }
        } while (validFields < 81);
        SudokuLinkedFieldsInitialiser.init(sudoku);
        return sudoku;
    }

    public Sudoku getEmptySudokuModel() {
        sudoku = new Sudoku(new NineSets(), new NineSets(), new NineSets());
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                insertNumberIntoSudoku(row, column, 0);
            }
        }
        return sudoku;
    }


    private void insertNumberIntoSudoku(int row, int column, int number) {
        SudokuField field = new SudokuField(this.validFields, number);
        sudoku.getHorizontalLines().get(row).add(field);
        sudoku.getVerticalLines().get(column).add(field);
        sudoku.getCubes().get(sudoku.getCubicleNumber(row, column)).add(field);
    }

    private boolean numberIsUnique(int row, int column, int number) {
        int cubicleNumber = sudoku.getCubicleNumber(row, column);
        NineFields vertical = sudoku.getVerticalLines().get(column);
        NineFields horizontal = sudoku.getHorizontalLines().get(row);
        NineFields cubes = sudoku.getCubes().get(cubicleNumber);
        if (!vertical.contains(number)
                && !horizontal.contains(number)
                && !cubes.contains(number)) {
            return true;
        } else {
            return false;
        }

    }

    List<Integer> getNineUniqueNumbersInRandomOrder() {
        List randomNumbers = new ArrayList();
        while (randomNumbers.size() < 9) {
            int randomNumber = getRandomSudokuNumber();
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private int getRandomSudokuNumber() {
        return (int) (Math.random() * 9) + 1;
    }

}
