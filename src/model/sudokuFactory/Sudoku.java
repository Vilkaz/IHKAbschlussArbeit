package model.sudokuFactory;

import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class Sudoku {

    private NineSets verticalLines = new NineSets();
    private NineSets horizontalLines = new NineSets();
    private NineSets cubics = new NineSets();

    public Sudoku(NineSets verticalLines, NineSets horizontalLines, NineSets cubics) {
        this.verticalLines = verticalLines;
        this.horizontalLines = horizontalLines;
        this.cubics = cubics;
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


    public NineSets getVerticalLines() {
        return verticalLines;
    }

    public NineSets getHorizontalLines() {
        return horizontalLines;
    }

    public NineSets getCubics() {
        return cubics;
    }
    /**
     * takes row and collumn from actual number, and calculates in which cubical Field the number is
     */
    public int getCubicleNumber(int row, int column) {
        return ((row / 3) * 3) + (column / 3);
    }

}
