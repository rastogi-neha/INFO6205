package edu.neu.coe.info6205.sort.elementary;

import java.util.*;

public class InsertionBenchmark {

    public static Integer[] RandomizeArray(int n){
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt(n);
        }
        return arr;
    }
    public static void main(String[] args){

        int n,runs=800;
        for( n=250;n<=8000;n=n*2) {

            System.out.println("InsertionSortBenchmark: \nN=" + n + " runs are " + runs);

            System.out.println("RANDOM ARRAY");
            Integer[] arr = RandomizeArray(n);
            long time = Benchmark_run(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("ORDERED ARRAY");
            arr = RandomizeArray(n);
            Arrays.sort(arr);
            time = Benchmark_run(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("REVERSE ORDERED ARRAY");
            arr = RandomizeArray(n);
            Arrays.sort(arr);
            Collections.reverse(Arrays.asList(arr));
            time = Benchmark_run(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println("PARTIALLY ORDERED ARRAY");
            arr = RandomizeArray(n);
            Arrays.sort(arr, 0, (4 * n) / 10);
            time = Benchmark_run(runs, n, arr);
            System.out.println("Average Time taken:" + time +" ns");

            System.out.println();
            runs=runs/2;
        }
    }

    public static long Benchmark_run(int runs,int n, Integer[] arr){
        long startTime,endTime,timeTaken=0;

        int totalRuns=runs;
        InsertionSort insertionSort = new InsertionSort();
        while (runs>0){
            startTime = System.nanoTime();
            insertionSort.sort(arr,0,n);
             endTime = System.nanoTime();

             long timeElapsed=endTime - startTime;
             timeTaken=timeTaken+timeElapsed;
             runs--;
        }
        timeTaken = timeTaken/totalRuns;

        return timeTaken;

    }
}
