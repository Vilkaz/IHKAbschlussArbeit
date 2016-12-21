package model.sudoku.rules;

import model.sudoku.Sudoku;
import model.sudoku.validator.LinkedFieldSizeValidator;

import java.util.Collection;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuRules {
    private Collection<SudokuRule> rules;

    public SudokuRules() {
        this.rules = SudokuRulesFactory.getRules();
    }

    public void teachRules(Sudoku sudoku) {
        do {
            for (SudokuRule rule : rules) {
                rule.implementRule(sudoku);
            }
        } while (!LinkedFieldSizeValidator.areAllFieldsValide(sudoku.getAllFields()));
    }
}
