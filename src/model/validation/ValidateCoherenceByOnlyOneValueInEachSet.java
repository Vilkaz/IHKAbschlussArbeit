package model.validation;

import model.sudokuFactory.Sudoku;
import model.sudokuFactory.SudokuFactory;
import model.sudokuFactory.SudokuField;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class ValidateCoherenceByOnlyOneValueInEachSet implements SudokuRule {
    SudokuFactory sudokuFactory = new SudokuFactory();

    @Override
    public void validate(Sudoku sudoku) {
        Sudoku newSudoku = sudokuFactory.getSudoku();
        List<SudokuField> checkList = sudoku.getAllFields();
        List<SudokuField> freshList = newSudoku.getAllFields();
        for (int outerCounter =0;outerCounter<sudoku.getAllFields().size();outerCounter++){
            {
                SudokuField checkField = checkList.get(outerCounter);
                SudokuField freshField = freshList.get(outerCounter);
                List<Integer> listOfLinkedIDs = checkField.getLinkedFieldsIDs();
                for (int i:listOfLinkedIDs){
                    SudokuField check = freshField.getLinkedFieldByID(i);
                    if (check.getValue()==freshField.getValue()){
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
