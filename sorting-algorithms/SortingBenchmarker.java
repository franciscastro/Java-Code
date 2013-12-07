/**
*	Author: Francisco Enrique Vicente G. Castro, MIT and Proceso Fernandez, PhD
*/

import java.util.*;
import java.io.File;

public class SortingBenchmarker {
	static final String DELIMITER = "\t";
	static final int NUM_EXPERIMENTS = 30;
	
	public static void main ( String[] args ) throws Exception
	{
		Scanner sc = new Scanner(new File("SortingInput.txt"));

		int numCases = sc.nextInt();
		
		for (int i = 0; i < numCases; ++i)
			benchmark(sc);
		
		sc.close();
	}
	
	
	public static void benchmark (Scanner sc)
	{
		int numItems = sc.nextInt();
		int[] arrOrig = new int[numItems];
		
		// store contents to an array
		for (int i = 0; i < numItems; ++i)
		{
			arrOrig[i] = sc.nextInt();
		}

		System.out.println("\n");

		SortingAlgorithm sSort = new SelectionSort( arrOrig, numItems );
		System.out.printf("Selection Sort\t: %d %s %.2e \n", numItems, DELIMITER, sSort.getAverageRunTime(NUM_EXPERIMENTS));
		
		SortingAlgorithm iSort = new InsertionSort( arrOrig, numItems );
		System.out.printf("Insertion Sort\t: %d %s %.2e \n", numItems, DELIMITER, iSort.getAverageRunTime(NUM_EXPERIMENTS));
		
		SortingAlgorithm shSort = new ShellSort( arrOrig, numItems );
		System.out.printf("Shell Sort\t: %d %s %.2e \n", numItems, DELIMITER, shSort.getAverageRunTime(NUM_EXPERIMENTS));
		
		SortingAlgorithm mSort = new MergeSort( arrOrig, numItems );
		System.out.printf("Merge Sort\t: %d %s %.2e \n", numItems, DELIMITER, mSort.getAverageRunTime(NUM_EXPERIMENTS));

		SortingAlgorithm hSort = new HeapSort( arrOrig, numItems );
		System.out.printf("Heap Sort\t: %d %s %.2e \n", numItems, DELIMITER, hSort.getAverageRunTime(NUM_EXPERIMENTS));

		SortingAlgorithm qSort = new QuickSort( arrOrig, numItems );
		System.out.printf("Quick Sort\t: %d %s %.2e \n", numItems, DELIMITER, qSort.getAverageRunTime(NUM_EXPERIMENTS));

		SortingAlgorithm cSort = new CountingSort( arrOrig, numItems );
		System.out.printf("Counting Sort\t: %d %s %.2e \n", numItems, DELIMITER, cSort.getAverageRunTime(NUM_EXPERIMENTS));

		SortingAlgorithm rSort = new RadixSort( arrOrig, numItems );
		System.out.printf("Radix Sort\t: %d %s %.2e \n", numItems, DELIMITER, rSort.getAverageRunTime(NUM_EXPERIMENTS));
		
		// System.out.printf("%d %s %.2e %s %.2e \n", numItems, DELIMITER, sSort.getAverageRunTime(NUM_EXPERIMENTS), DELIMITER, iSort.getAverageRunTime(NUM_EXPERIMENTS));
		//System.out.println();
		
	}
	
}

