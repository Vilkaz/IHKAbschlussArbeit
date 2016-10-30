package model.sudokuGenerator;

import java.util.ArrayList;

/**
 * Created by vkukanauskas on 29/10/2016.
 */
public class NineFieldSet {
    private List<SudokuField>  fields = new ArrayList();

    public boolean contains(int value){
        boolean contains = false;
        for (SudokuField field : fields){
            if (field.getValue() == value){
                contains = true;
            }
        }
        return  contains;
    }



    public SudokuField[] getFields() {
        return fields;
    }
}
