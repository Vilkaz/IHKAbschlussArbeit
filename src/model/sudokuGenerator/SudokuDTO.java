package model.sudokuGenerator;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuDTO  {

    private NineSets verticalLines ;
    private NineSets horizontalLines;
    private NineSets cubics;

    public SudokuDTO() {
    }

    public NineSets getVerticalLines() {
        return verticalLines;
    }

    public NineSets getHorizontalLines() {
        return horizontalLines;
    }

    public NineSets getCubics() {
        return cubics;
    }
}
