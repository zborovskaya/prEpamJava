package by.training.task03.service;
import  by.training.task03.entity.Array;

public class MergeSort implements Sorting{
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */

    public void sort(Array array, boolean isIncreasing) {
        if(isIncreasing) {
            int[] tmp;
            int[] currentSrc = array.getArray();
            int[] currentDest = new int[array.getLength()];

            int size = 1;
            while (size < array.getLength()) {
                for (int i = 0; i < array.getLength(); i += 2 * size) {
                    merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
                }
                tmp = currentSrc;
                currentSrc = currentDest;
                currentDest = tmp;
                size = size * 2;
            }
            for(int index = 0; index < array.getLength(); index++) {
                array.setValues(index, currentSrc[index]);
            }
        }
        else {
            int[] tmp;
            int[] currentSrc = array.getArray();
            int[] currentDest = new int[array.getLength()];

            int size = 1;
            while (size < array.getLength()) {
                for (int i = 0; i < array.getLength(); i += 2 * size) {
                    merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
                }
                tmp = currentSrc;
                currentSrc = currentDest;
                currentDest = tmp;
                size = size * 2;
            }
            for(int index = array.getLength(); index >= 0; index--) {
                array.setValues(index, currentSrc[index]);
            }
        }
    }

    public  void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for(int i = destStart; i < destStart + iterationCount; i++) {
            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
}
