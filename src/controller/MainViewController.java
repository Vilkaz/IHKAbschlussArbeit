package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.sudoku.*;
import model.sudoku.rules.SudokuRules;
import model.sudoku.view.FieldOperator;
import model.sudoku.view.HintText;
import model.sudoku.view.SudokuBinder;
import model.sudoku.view.ViewDataDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vilkas on 02/11/2016.
 */
public class MainViewController {


    private SudokuFactory factory = new SudokuFactory();
    private SudokuBinder binder = new SudokuBinder();
    private Sudoku sudoku;


    @FXML
    private Pane mainPane;

    @FXML
    private GridPane sudokuGrid;

    @FXML
    private Button generateSudoku, learnToSolve, solveSudoku;
    @FXML
    private Text hintText;

    @FXML
    private GridPane cube1, cube2, cube3, cube4, cube5, cube6, cube7, cube8, cube9;

    @FXML
    public void generateSudoku(ActionEvent actionEvent) {
        this.sudoku = factory.getSudoku();
        binder.bindSudokuFieldsToView(sudoku, getGridCubes());
        hideText();
    }

    @FXML
    public void learnToSolve(ActionEvent actionEvent) {
        if (this.sudoku != null) {
            showHint("lerne Regel, bitte warten");
            disableMainButtons();
            SudokuRules rules = new SudokuRules();
            rules.teachRules(this.sudoku);
            hideText();
            enableMainButtons();
        } else {
            showHint("bitte zuerst Sudoku generieren");
        }

    }

    private void disableMainButtons() {
        generateSudoku.setDisable(true);
        learnToSolve.setDisable(true);
        solveSudoku.setDisable(true);
    }

    private void enableMainButtons() {
        generateSudoku.setDisable(false);
        learnToSolve.setDisable(false);
        solveSudoku.setDisable(false);
    }


    @FXML
    public void solveSudoku(ActionEvent actionEvent) {
    }

    private List<GridPane> getGridCubes() {
        ArrayList<GridPane> cubes = new ArrayList<GridPane>(
                Arrays.asList(cube1, cube2, cube3, cube4, cube5, cube6, cube7, cube8, cube9));
        return cubes;
    }

    private void showHint(String hint) {
        HintText.showText(hint, this.hintText);
    }

    private void hideText() {
        HintText.hideText(this.hintText);
    }

    public void showFieldMenu(ActionEvent event) {
        ViewDataDTO data = getViewDataDTO(event);
        FieldOperator operator = new FieldOperator();
        Button button = operator.getButton(data);
        mainPane.getChildren().add(button);
    }

    private ViewDataDTO getViewDataDTO(ActionEvent event) {
        ViewDataDTO data = new ViewDataDTO(
                this.mainPane,
                this.sudokuGrid,
                this.sudoku,
                event
        );
        return data;
    }


    public void showLindekFields(ActionEvent event) {
        Button button = (Button) event.getSource();

        System.out.println();
    }
}
