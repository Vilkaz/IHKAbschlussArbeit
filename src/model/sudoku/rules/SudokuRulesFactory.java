package model.sudoku.rules;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuRulesFactory {
    public static Collection<SudokuRule> getRules() {
        Collection<SudokuRule> rules = new ArrayList<SudokuRule>();
        OnlyOneValueInEachSet coherehnceByValueRule = new OnlyOneValueInEachSet();
        rules.add(coherehnceByValueRule);
        return rules;
    }
}
