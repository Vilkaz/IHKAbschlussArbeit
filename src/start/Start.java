package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.sudoku.Sudoku;
import model.sudoku.SudokuFactory;
import model.sudoku.rules.LinkedFieldSizeValidator;
import model.sudoku.rules.SudokuRules;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        Sudoku sudoku = new SudokuFactory().getEmptySudokuModel();
        Sudoku sudoku = new SudokuFactory().getSudoku();
        SudokuRules validator = new SudokuRules();
        int i = 0;
        do{
            validator.learnRules(sudoku);
            i++;
        } while (!LinkedFieldSizeValidator.areAllFieldsValide(sudoku.getAllFields()));
        System.out.println(i);
    }
}
