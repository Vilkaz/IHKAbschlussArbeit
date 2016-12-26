package model.sudoku.view;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.sudoku.sudoku.Sudoku;

/**
 * Created by vkukanauskas on 05/11/2016.
 */
public class ViewDataDTO {
    private Pane mainPane;
    private GridPane sudokuGrid;
    private Sudoku sudoku;
    private ActionEvent event;

    public ViewDataDTO(Pane mainPane, GridPane sudokuGrid, Sudoku sudoku, ActionEvent event) {
        this.mainPane = mainPane;
        this.sudokuGrid = sudokuGrid;
        this.sudoku = sudoku;
        this.event = event;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public GridPane getSudokuGrid() {
        return sudokuGrid;
    }

    public Sudoku getSudoku() {
        return sudoku;
    }

    public ActionEvent getEvent() {
        return event;
    }
}
