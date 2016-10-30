package model.validation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vilkas on 30/10/2016.
 */
public class SudokuRulesFactory {
    public static Collection<SudokuRule> getRules() {
        Collection<SudokuRule> rules = new ArrayList<SudokuRule>();
        ValidateCoherenceByOnlyOneValueInEachSet coherehnceByValueRule = new ValidateCoherenceByOnlyOneValueInEachSet();
        rules.add(coherehnceByValueRule);
        return rules;
    }
}
