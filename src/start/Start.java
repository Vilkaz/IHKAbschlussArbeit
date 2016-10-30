package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.sudokuFactory.Sudoku;
import model.sudokuFactory.SudokuFactory;
import model.validation.LinkedFieldSizeValidator;
import model.validation.SudokuValidator;

import java.util.List;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);
//        Sudoku sudoku = new SudokuFactory().getEmptySudokuModel();
        Sudoku sudoku = new SudokuFactory().getSudoku();
        SudokuValidator validator = new SudokuValidator();
        int i = 0;
        do{
            validator.validate(sudoku);
            i++;
        } while (!LinkedFieldSizeValidator.areAllFieldsValidated(sudoku.getAllFields()));
        System.out.println(i);
    }
}
