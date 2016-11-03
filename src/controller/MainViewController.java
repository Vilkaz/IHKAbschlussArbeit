package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.sudoku.*;
import model.sudoku.rules.SudokuRules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vilkas on 02/11/2016.
 */
public class MainViewController {

    private SudokuFactory factory = new SudokuFactory();
    private Sudoku sudoku;

    @FXML
    private GridPane cube1, cube2, cube3, cube4, cube5, cube6, cube7, cube8, cube9;

    @FXML
    public void generateSudoku(ActionEvent actionEvent) {
        this.sudoku = factory.getSudoku();
        bindSudokuFieldsToView(this.sudoku);
    }

    private void bindSudokuFieldsToView(Sudoku sudoku) {
        NineSets sudokuCubes = sudoku.getCubes();
        List<GridPane> gridCubes = getGridCubes();
        for (int i = 0; i < 9; i++) {
            bindModelCubeToViewCube(sudokuCubes.get(i), gridCubes.get(i));
        }
    }

    private void bindModelCubeToViewCube(NineFields modelCube, GridPane viewCube) {
        for (int i = 0; i < 9; i++) {
            Button button = (Button) viewCube.getChildren().get(i);
            SudokuField field = modelCube.getFields().get(i);
            button.textProperty().bindBidirectional(field.viewValueProperty());
        }
    }

    @FXML
    public void learnToSolve(ActionEvent actionEvent) {
        Sudoku backup = factory.getSudoku();
        backup.copyValuesFrom(this.sudoku);
        SudokuRules rules = new SudokuRules();
        rules.learnRules(this.sudoku);
        this.sudoku.copyValuesFrom(backup);
    }


    @FXML
    public void solveSudoku(ActionEvent actionEvent) {
    }

    private List<GridPane> getGridCubes() {
        ArrayList<GridPane> cubes = new ArrayList<GridPane>(
                Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6, cube7, cube8, cube9));
        return cubes;
    }

    public void fieldContextMenu(ContextMenuEvent contextMenuEvent) {
        System.out.println();
    }

    public void fieldMouseClick(MouseEvent mouseEvent) {
        System.out.println();
    }
}
