package edu.neu.coe.info6205.sort.elementary;

import java.util.*;

public class InsertionBenchmark {

    public static void main(String[] args){

        int n,runs=800;
        long time;
        for( n=250;n<=8000;n=n*2) {

            System.out.println("InsertionSortBenchmark: \nN=" + n + " runs are " + runs);

            System.out.println("RANDOM ARRAY");
            Integer[] arr = generateRandomArray(n);
            time = runInsertionBenchmark(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("ORDERED ARRAY");
            arr = generateRandomArray(n);
            Arrays.sort(arr);
            time = runInsertionBenchmark(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("REVERSE ORDERED ARRAY");
            arr = generateRandomArray(n);
            Arrays.sort(arr, Comparator.reverseOrder());
            time = runInsertionBenchmark(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("PARTIALLY ORDERED ARRAY");
            arr = generateRandomArray(n);
            Arrays.sort(arr, 0, n/2);
            time = runInsertionBenchmark(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println();
            runs=runs/2;
        }
    }

    public static long runInsertionBenchmark(int runs,int size, Integer[] arr){
        long startTime,endTime,timeTaken=0;

        int totalRuns=runs;
        InsertionSort insertionSort = new InsertionSort();
        while (runs>0){

            startTime = System.nanoTime();
            if(size!=0)
                insertionSort.sort(arr,0,size);
             endTime = System.nanoTime();

             long timeElapsed=endTime - startTime;
             timeTaken=timeTaken+timeElapsed;
             runs--;
        }
        timeTaken = timeTaken/totalRuns;

        return timeTaken;
    }

    public static Integer[] generateRandomArray(int n){
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
