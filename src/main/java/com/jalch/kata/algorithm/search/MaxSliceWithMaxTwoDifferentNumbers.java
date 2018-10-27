package com.jalch.kata.algorithm.search;

import java.util.*;

public class MaxSliceWithMaxTwoDifferentNumbers {

    //TODO: clean.
    public static long calculate(List<Integer> inputSequence) {
        if (inputSequence == null) return 0;
        if (inputSequence.size() <= 1) return inputSequence.size();

        int maxSliceSize = 0;
        Map<Integer, Integer> items = new HashMap<>();

        int startIndex = 0;
        int endIndex = inputSequence.size() - 1;

        while (startIndex <= endIndex) {
            items.put(inputSequence.get(startIndex), startIndex);

            for (int i = startIndex + 1; i < inputSequence.size(); i++) {
                if (items.get(inputSequence.get(i)) == null) {

                    if (items.entrySet().size() < 2) {
                        items.put(inputSequence.get(i), i);

                        if (i == endIndex) {
                            maxSliceSize = Math.max(maxSliceSize, i - startIndex + 1);
                            startIndex = inputSequence.size();
                            break;
                        }

                    } else {
                        maxSliceSize = Math.max(maxSliceSize, i - startIndex);

                        int currentInteger = inputSequence.get(i - 1);
                        int firstFoundIndex = 0;
                        for (int k = i - 1; k >= 0; k--) {
                            if (inputSequence.get(k) != currentInteger) {
                                firstFoundIndex = k + 1;
                                break;
                            }
                        }
                        startIndex = firstFoundIndex;
                        items.clear();
                        break;
                    }


                } else if (i == endIndex) {
                    maxSliceSize = Math.max(maxSliceSize, i - startIndex + 1);
                    startIndex = inputSequence.size();
                    break;
                }
            }
        }
        return maxSliceSize;
    }


//   Initial solution. Test case 11 and 13 not passed.
//
//    public static long calculate(List<Integer> inputSequence) {
//        if (inputSequence == null) return 0;
//        if (inputSequence.size() <= 1) return inputSequence.size();
//
//        long maxSliceSize = 2;
//
//        int first = inputSequence.get(0);
//        long firstCount = 0;
//        int second = inputSequence.get(1);
//        long secondCount = 0;
//
//
//        for (Integer current : inputSequence) {
//            if (current == first) {
//                firstCount++;
//            } else if (current == second) {
//                secondCount++;
//            } else if (first == second) {
//                second = current;
//                secondCount = 1;
//            } else {
//                first = second;
//                firstCount = secondCount;
//                second = current;
//                secondCount = 1;
//            }
//            long currentCount = firstCount + secondCount;
//
//            if (currentCount > maxSliceSize) maxSliceSize = currentCount;
//        }
//
//        return maxSliceSize;
//    }
// assertThat(underTest.calculate(Arrays.asList(1,1,2,1,2,3,3,3,3)), is(5L)); (output: 6)

}
