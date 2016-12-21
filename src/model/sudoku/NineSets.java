package model.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class NineSets {

    private List<NineFields> sets = new ArrayList<NineFields>();

    public NineSets() {
        for (int i =0;i<9;i++){
            sets.add(new NineFields());
        }
    }


    public List<NineFields> getSets() {
        return sets;
    }

    public NineFields get(int i){
        return sets.get(i);
    }


}