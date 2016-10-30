package model.sudokuGenerator;

/**
 * Created by vkukanauskas on 27/10/2016.
 */
public class SudokuDTO  {

    private NineSets verticalLines = new NineSets();
    private NineSets horizontalLines = new NineSets();
    private NineSets cubics = new NineSets();

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
    /**
     * takes row and collumn from actual number, and calculates in which cubical Field the number is
     */
    public int getCubicleNumber(int row, int column) {
        return ((row / 3) * 3) + (column / 3);
    }

}
