package model.sudoku.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.sudoku.sudoku.SudokuField;

import java.util.List;

/**
 * Created by vkukanauskas on 05/11/2016.
 */
public class FieldOperator {
    Button button;

    public Button getButton(ViewDataDTO data) {
        button = new Button();
        setDeletoOrCalculate( data);
        setOnMouseExitEvent(data);
        setButtonCoordinates(data);
        return button;
    }

    private void setOnMouseExitEvent(ViewDataDTO data) {
        this.button.setOnMouseExited(event1 -> data.getMainPane().getChildren().remove(this.button));
    }

    public void setDeletoOrCalculate(ViewDataDTO data) {
        Button source = (Button) data.getEvent().getSource();
        if (!source.getText().equals("")) {
            this.button.setText("Löschen");
            this.button.setOnMouseClicked(event1 ->  deleteFieldValue(data));

        } else {
            this.button.setText("Berechnen");
            int id = Integer.parseInt(source.getId());
            List<SudokuField> fields = data.getSudoku().getAllFields();
            this.button.setOnMouseClicked(event1 -> fields.get(id).calculateValue());
        }
    }

    private void setButtonCoordinates(ViewDataDTO data) {
        Button source = (Button) data.getEvent().getSource();
        Button target = (Button)data.getEvent().getTarget();
        Pane pane = (Pane) target.getParent();
        this.button.setLayoutX(source.getLayoutX() + data.getSudokuGrid().getLayoutX()+ pane.getLayoutX());
        this.button.setLayoutY(source.getLayoutY() + data.getSudokuGrid().getLayoutY()+pane.getLayoutY());
    }

    private void deleteFieldValue(ViewDataDTO data){
        Button source = (Button) data.getEvent().getSource();
        source.setText("");
        int id = Integer.parseInt(source.getId());
        List<SudokuField> fields = data.getSudoku().getAllFields();
        fields.get(id).setValue(0);
        /**
         *  the code works, but javaFX wants more explicit parent,
         *  so we have an exception here.
         */
//        data.getMainPane().getChildren().remove(this.button);
    }

}
