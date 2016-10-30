package model.sudokuGenerator;

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

    public void add(int value){
        sets.get(sets.size()-1).add(value);
    }

    public List<NineFields> getSets() {
        return sets;
    }

    public NineFields get(int i){
        return sets.get(i);
    }

    public boolean contains(int i){
        for (NineFields set : sets){
             if (set.contains(i)){
                 return true;
             }
        }
        return false;
    }
}