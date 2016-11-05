package model.sudoku.view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.sudoku.NineFields;
import model.sudoku.NineSets;
import model.sudoku.Sudoku;
import model.sudoku.SudokuField;

import java.util.List;

/**
 * Created by vkukanauskas on 05/11/2016.
 */
public class SudokuBinder {

    public void bindSudokuFieldsToView(Sudoku sudoku,List<GridPane> gridCubes ) {
        NineSets sudokuCubes = sudoku.getCubes();
        for (int i = 0; i < 9; i++) {
            bindModelCubeToViewCube(sudokuCubes.get(i), gridCubes.get(i));
        }
    }

    private void bindModelCubeToViewCube(NineFields modelCube, GridPane viewCube) {
        for (int i=0;i<9;i++){
            Button button = (Button) viewCube.getChildren().get(i);
            SudokuField field = modelCube.getFields().get(i);
            button.textProperty().bindBidirectional(field.viewValueProperty());
            button.setId(String.valueOf(field.getId()));
        }
    }

}
