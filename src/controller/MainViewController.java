package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.SudokuField;

/**
 * Created by Vilkas on 02/11/2016.
 */
public class MainViewController {

    SudokuFactory factory = new SudokuFactory();

    @FXML
    public GridPane cube1,cube2,cube3,cube4,cube5,cube6,cube7,cube8,cube9;

    @FXML
    public void generateSudoku(ActionEvent actionEvent) {
        Sudoku sudoku = factory.getSudoku();
        Button button = (Button) cube1.getChildren().get(0);
        SudokuField field = sudoku.getAllFields().get(0);
        button.textProperty().bind(field.viewValueProperty());
        System.out.println();
    }

    @FXML
    public void learnToSolve(ActionEvent actionEvent) {
    }


    @FXML
    public void solveSudoku(ActionEvent actionEvent) {
    }
}
