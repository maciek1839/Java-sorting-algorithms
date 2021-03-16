package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class CountingSort extends AlgorithmBase {

    CountingSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N+M)";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int theLowest = arrayToSort[0], theHighest = arrayToSort[0], listCapacity;

        for (int tDatum : arrayToSort) {
            if (tDatum < theLowest)
                theLowest = tDatum;
            else if (tDatum > theHighest)
                theHighest = tDatum;
        }
        listCapacity = theHighest - theLowest + 1;//look at this 325-320=5 but 6 numbers->320,321,322,323,324,325
        //array stores value from the lowest to the biggest
        List<Tuple2<Integer, Integer>> lowHighValues = new ArrayList<>(listCapacity);
        for (int i = 0; i < listCapacity; i++) {
            lowHighValues.add(i, new Tuple2<>(theLowest + i, 0));
        }
        //count each value
        for (int tDatum : arrayToSort) {
            lowHighValues.set(tDatum - theLowest, new Tuple2<>(lowHighValues.get(tDatum - theLowest)._1(), lowHighValues.get(tDatum - theLowest)._2() + 1));

        }
        //flush all countered values
        int howMany, tableIndex = 0;
        for (int i = 0; tableIndex < arrayToSort.length && i < listCapacity; i++) {
            howMany = lowHighValues.get(i)._2();
            if (howMany > 0) {
                while (howMany > 0) {
                    arrayToSort[tableIndex] = lowHighValues.get(i)._1();
                    howMany -= 1;
                    tableIndex += 1;
                }
            }
        }
        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.COUNTING_SORT;
    }


    @Override
    public String toString() {
        return "Counting Sort ";
    }
}
