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

    public void bindSudokuFieldsToView(Sudoku sudoku, List<GridPane> gridCubes) {
        NineSets sudokuCubes = sudoku.getCubes();
        for (int i = 0; i < 9; i++) {
            bindModelCubeToViewCube(sudokuCubes.get(i), gridCubes.get(i));
        }
    }

    private void bindModelCubeToViewCube(NineFields modelCube, GridPane viewCube) {
        bindSudokuFieldToView(modelCube.getFields().get(0), (Button) viewCube.getChildren().get(0));
        bindSudokuFieldToView(modelCube.getFields().get(1), (Button) viewCube.getChildren().get(1));
        bindSudokuFieldToView(modelCube.getFields().get(2), (Button) viewCube.getChildren().get(2));
        bindSudokuFieldToView(modelCube.getFields().get(3), (Button) viewCube.getChildren().get(3));
        bindSudokuFieldToView(modelCube.getFields().get(4), (Button) viewCube.getChildren().get(6));
        bindSudokuFieldToView(modelCube.getFields().get(5), (Button) viewCube.getChildren().get(7));
        bindSudokuFieldToView(modelCube.getFields().get(6), (Button) viewCube.getChildren().get(4));
        bindSudokuFieldToView(modelCube.getFields().get(7), (Button) viewCube.getChildren().get(8));
        bindSudokuFieldToView(modelCube.getFields().get(8), (Button) viewCube.getChildren().get(5));
    }


    private void bindSudokuFieldToView(SudokuField field, Button button) {
        button.textProperty().bindBidirectional(field.viewValueProperty());
        button.setId(String.valueOf(field.getId()));
    }

}
