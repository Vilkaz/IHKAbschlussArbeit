package model.sudoku.view;

import javafx.scene.text.Text;

/**
 * Created by vkukanauskas on 05/11/2016.
 */
public class HintText {

    public static void hideText(Text text ){
        text.setText("");
    }

    public static void showText(String hint, Text text){
        text.setText(hint);
    }



}
