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
        BCISsort.sort(smallRandomArray);
        countingSort.countSort(smallRandomArray, smallRandomArray.length);
    }

    public static void fillRandomArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillSortedArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1; 
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillReversedArray(int[] arr) {
        int last = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = last; 
            last-=1;
        }
        System.out.println(Arrays.toString(arr));
    }

}