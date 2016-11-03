package model.sudoku;

import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class Sudoku {

    private NineSets verticalLines = new NineSets();
    private NineSets horizontalLines = new NineSets();
    private NineSets cubes = new NineSets();

    public Sudoku(NineSets verticalLines, NineSets horizontalLines, NineSets cubes) {
        this.verticalLines = verticalLines;
        this.horizontalLines = horizontalLines;
        this.cubes = cubes;
    }

    public Sudoku()throws InitializationError {
        throw new InitializationError("Use Sudoku Factoryfor Initialisation");
    }

    public List<SudokuField> getAllFields(){
        List<SudokuField> fields = new ArrayList();
            for (NineFields nineFields : horizontalLines.getSets()){
                for (SudokuField field : nineFields.getFields()){
                    fields.add(field);
                }
            }
        return fields;
    }

    public void copyValuesFrom(Sudoku sudoku){
        List<SudokuField> myFields = this.getAllFields();
        for (int i=0;i<myFields.size();i++){
            SudokuField valueField = sudoku.getAllFields().get(i);
            SudokuField myField = myFields.get(i);
            myField.setValue(valueField.getValue());
        }

    }


    public NineSets getVerticalLines() {
        return verticalLines;
    }

    public NineSets getHorizontalLines() {
        return horizontalLines;
    }

    public NineSets getCubes() {
        return cubes;
    }
    /**
     * takes row and collumn from actual number, and calculates in which cubical Field the number is
     */
    public int getCubicleNumber(int row, int column) {
        return ((row / 3) * 3) + (column / 3);
    }

}
