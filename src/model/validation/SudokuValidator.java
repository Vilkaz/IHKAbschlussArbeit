package model.validation;

import model.sudokuFactory.Sudoku;

import java.util.Collection;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuValidator {
    private Collection<SudokuRule> rules;

    public SudokuValidator() {
        this.rules = SudokuRulesFactory.getRules();
    }

    public void validate(Sudoku sudoku){
        for (SudokuRule rule:rules){
            rule.validate(sudoku);
        }
    }
}
