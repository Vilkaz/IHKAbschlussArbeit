package model.sudoku.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 05/11/2016.
 */
public class FieldClicked {

      public static Button getButton(ActionEvent event){
        Button source = (Button) event.getSource();
        Button button = new Button();
        if (!source.getText().equals("")){
            button.setText("Löschen");
        } else {
            button.setText("Berechnen");
        }
        return button;
    }

}
