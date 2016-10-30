package model.sudokuGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class NineSets {

    private List<NineFieldSet> sets = new ArrayList<NineFieldSet>();

    public List getSets() {
        return sets;
    }

    public boolean contains(int i){
        for (NineFieldSet set : sets){
             if (set.contains(i)){
                 return true;
             }
        }
        return false;
    }
}