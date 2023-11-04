package TE1;

import java.util.Arrays;
import java.util.Random;

public class CompareAlgorithm {
    public static int[] smallRandomArray = new int[500];
    public static int[] smallSortedArray = new int[500];
    public static int[] smallReversedArray = new int[500];
    public static int[] mediumRandomArray = new int[5000];
    public static int[] mediumSortedArray = new int[5000];
    public static int[] mediumReversedArray = new int[5000];
    public static int[] bigRandomArray = new int[50000];
    public static int[] bigSortedArray = new int[50000];
    public static int[] bigReversedArray = new int[50000];

    public static void main(String[] args){
        fillSortedArray(smallSortedArray);
        fillSortedArray(mediumSortedArray);
        fillSortedArray(bigSortedArray);

        fillRandomArray(smallRandomArray);
        fillRandomArray(mediumRandomArray);
        fillRandomArray(bigRandomArray);

        fillReversedArray(smallReversedArray);
        fillReversedArray(mediumReversedArray);
        fillReversedArray(bigReversedArray);

        BCIS BCISsort = new BCIS();
        CountingSort countingSort = new CountingSort();

        int[] copySmallSorted =Arrays.copyOf(smallSortedArray, smallSortedArray.length);
        int[] copySmallRandom =Arrays.copyOf(smallRandomArray, smallRandomArray.length);
        int[] copySmallReversed =Arrays.copyOf(smallReversedArray, smallReversedArray.length);

        int[] copyMediumSorted =Arrays.copyOf(mediumSortedArray, mediumSortedArray.length);
        int[] copyMediumRandom =Arrays.copyOf(mediumRandomArray, mediumRandomArray.length);
        int[] copyMediumReversed =Arrays.copyOf(mediumReversedArray, mediumReversedArray.length);

        int[] copyBigSorted =Arrays.copyOf(bigSortedArray, bigSortedArray.length);
        int[] copyBigRandom =Arrays.copyOf(bigRandomArray, bigRandomArray.length);
        int[] copyBigReversed =Arrays.copyOf(bigReversedArray, bigReversedArray.length);
        
        System.out.println("Compare Small Sorted Array");
        compareSorting(BCISsort, countingSort, smallSortedArray, copySmallSorted);
        System.out.println("Compare Small Random Array");
        compareSorting(BCISsort, countingSort, smallRandomArray, copySmallRandom);
        System.out.println("Compare Small Reversed Array");
        compareSorting(BCISsort, countingSort, smallReversedArray, copySmallReversed);

        System.out.println("Compare Medium Sorted Array");
        compareSorting(BCISsort, countingSort, mediumSortedArray, copyMediumSorted);
        System.out.println("Compare Medium Random Array");
        compareSorting(BCISsort, countingSort, mediumRandomArray, copyMediumRandom);
        System.out.println("Compare Medium Reversed Array");
        compareSorting(BCISsort, countingSort, mediumReversedArray, copyMediumReversed);

        System.out.println("Compare Big Sorted Array");
        compareSorting(BCISsort, countingSort, bigSortedArray, copyBigSorted);
        System.out.println("Compare Big Random Array");
        compareSorting(BCISsort, countingSort, bigRandomArray, copyBigRandom);
        System.out.println("Compare Big Reversed Array");
        compareSorting(BCISsort, countingSort, bigReversedArray, copyBigReversed);
         
    }

    public static void compareSorting(BCIS BCISsort, CountingSort countingSort, int[] array, int[] copyArray){
        long startTimeBCIS = System.nanoTime();
        BCISsort.sort(array);
        long endTimeBCIS = System.nanoTime();
        
        double executionTimeBCIS = (endTimeBCIS - startTimeBCIS) / 1e6;
        System.out.println("BCIS Sort Execution Time: " + executionTimeBCIS + " milliseconds");

        long startTimeCountingSort = System.nanoTime();
        countingSort.countSort(copyArray, copyArray.length);
        long endTimeCountingSort = System.nanoTime();

        double executionTimeCountingSort = (endTimeCountingSort - startTimeCountingSort) / 1e6; // Convert to milliseconds
        System.out.println("Counting Sort Execution Time: " + executionTimeCountingSort + " milliseconds");

        System.out.println("");
    }

    public static void fillRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    public static void fillSortedArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1; 
        }
    }

    public static void fillReversedArray(int[] arr) {
        int last = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = last; 
            last-=1;
        }
    }

}