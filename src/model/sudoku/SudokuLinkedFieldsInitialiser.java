package model.sudoku;

import java.util.List;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuLinkedFieldsInitialiser {
    public static void init(Sudoku sudoku){
        List<SudokuField> allFields = sudoku.getAllFields();
        for (SudokuField initialisedField : allFields){
          int i = 0;
            for (SudokuField linkedField : allFields){
              if (!(initialisedField==linkedField)){
                  initialisedField.getLinkedFields().add(linkedField);
                  i++;
              }

          }
        }
    }
}
