package model.validation;

import model.sudokuFactory.Sudoku;

/**
 * Created by Vilkas on 30/10/2016.
 */
public interface SudokuRule {
   void validate (Sudoku sudoku);
}
