package model.sudokuGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuGenerator {
    SudokuDTO sudoku = new SudokuDTO();

    public SudokuDTO getSudoku() {
        sudoku = new SudokuDTO();
        int validFields;
        do {
            validFields = 0;
            initial:
            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                    int trys = 0;
                    for (int number : get9UniqueNumbersInRandomOrder()) {
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
        return sudoku;
    }


    private void insertNumberIntoSudoku(int row, int column, int number) {
        sudoku.getHorizontalLines().get(row).add(number);
        sudoku.getVerticalLines().get(column).add(number);
        sudoku.getCubics().get(sudoku.getCubicleNumber(row, column)).add(number);
        System.out.println();
    }

    private boolean numberIsUnique(int row, int column, int number) {
        boolean isUnique = !(sudoku.getVerticalLines().get(column).contains(number) &&
                sudoku.getHorizontalLines().get(row).contains(number) &&
                sudoku.getCubics().get(sudoku.getCubicleNumber(row, column)).contains(number));
        return isUnique;
    }

    List<Integer> get9UniqueNumbersInRandomOrder() {
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
