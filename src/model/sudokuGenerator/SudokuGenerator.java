//package model.sudokuGenerator;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * Created by vkukanauskas on 27/10/2016.
// */
//public class SudokuGenerator {
//    NineSets vertical;
//    NineSets horizontal;
//    NineSets cubics;
//    SudokuDTO sudoku;
//
//    public SudokuDTO getSudoku() {
//        SudokuDTO sudoku = new SudokuDTO();
//
//        Collection<Integer> numbers = get9UniqueNumbersInRandomOrder();
//
//        for (int hor = 0; hor < 9; hor++) {
//            for (int ver = 0; ver < 9; ver++) {
//                for (int cube : numbers) {
//                    int trys = 0;
//                    for (int number : get9UniqueNumbersInRandomOrder()) {
//                        if (numberIsUnique(number)) {
//                            vertical.get(ver).
//                        }
//                    }
//
//                }
//                for (int number : get9UniqueNumbersInRandomOrder()) {
//                    if (isUnique(hor, ver, number)) {
//                        addNumberToGrid(hor, ver, number);
//                        numberCounter++;
//                        break;
//                    } else {
//                        trys++;
//                    }
//                }
//                if (trys == 9) break initial;
//            }
//        }
//        return sudoku;
//    }
//
//    private boolean numberIsUnique(int number) {
//        return !(vertical.contains(number) &&
//                horizontal.contains(number) &&
//                cubics.contains(number));
//    }
//
//    private void initSets() {
//        vertical = new NineSets();
//        horizontal = new NineSets();
//        cubics = new NineSets();
//    }
//
//    Collection<Integer> get9UniqueNumbersInRandomOrder() {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        while (result.size() < 9) {
//            int tempo = (int) (Math.random() * 9) + 1;
//            if (!result.contains(tempo)) {
//                result.add(tempo);
//            }
//        }
//        return result;
//
//    }
//
//}
