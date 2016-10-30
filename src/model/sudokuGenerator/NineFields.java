package model.sudokuGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 29/10/2016.
 */
public class NineFields {
    private List<SudokuField> fields = new ArrayList();


    public SudokuField get(int i){
        return fields.get(i);
    }

    public void add(int value){
        fields.add(new SudokuField(value));
    }

    public boolean contains(int value){
        boolean contains = false;
        for (SudokuField field : fields){
            if (field.getValue() == value){
                contains = true;
            }
        }
        return  contains;
    }

    public List getFields() {
        return fields;
    }
}
