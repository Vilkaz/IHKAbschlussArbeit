package model.sudoku.rules;

import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.SudokuField;

import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class OnlyOneValueInEachSet implements SudokuRule {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Override
    public void validate(Sudoku sudoku) {
        Sudoku newSudoku = sudokuFactory.getSudoku();
        sudoku.copyValuesFrom(newSudoku);

        List<SudokuField> checkList = sudoku.getAllFields();
        for (int outerCounter =0;outerCounter<sudoku.getAllFields().size();outerCounter++){
            {
                SudokuField checkField = checkList.get(outerCounter);
                List<Integer> listOfLinkedIDs = checkField.getLinkedFieldsIDs();
                for (int i:listOfLinkedIDs){
                    SudokuField check = checkField.getLinkedFieldByID(i);
                    if (check.getValue()==checkField.getValue()){
                        checkField.removeLinkedFieldByID(i);
                    }
                }
            }
        }
    }

    private  List<SudokuField> getNewSudokuFields(){
        return sudokuFactory.getSudoku().getAllFields();
    }
}
