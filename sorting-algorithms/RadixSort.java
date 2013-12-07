/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Radix sort algorithm
*	References:
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*	http://puzzlersworld.com/interview-questions/sort-the-array-radix-sort-java/
*/

import java.util.*;
import java.io.File;

public class RadixSort extends SortingAlgorithm {

	// Constant for the maximum number of significant digits to consider for each element to be sorted
	private final int SIGNIFICANT_DIGITS = 4;

	public RadixSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		this.radixsort( SIGNIFICANT_DIGITS );
	}

	private void radixsort( int significantDigits )
	{
		int place = 1;	// Current significant digit being considered

		// Do as many times as there are significant digits to be considered
		for ( int count = 0 ; count < significantDigits ; count++ ) {
			
			// Create the buckets
			ArrayList[] buckets = new ArrayList[10];

			// Create an ArrayList for each bucket
			for ( int countBucket = 0 ; countBucket < 10 ; countBucket++ ) {
				buckets[ countBucket ] = new ArrayList<Integer>();
			}

			// For each element in the array: 
			// Place the element in its correct position based on current significant digit
			for ( int countElement = 0 ; countElement < this.arr.length ; countElement++ ) {

				// Find the correct position for the element
				int position = ( (this.arr[ countElement ] / place) % 10 );	

				// Place the element in the position found
				buckets[ position ].add( this.arr[ countElement ] );
				
			}

			// Move to next significant digit
			place *= 10;

			// For monitoring the index of the array when transferring the elements to the main array
			int arrayIndex = 0;

			// Loop through each bucket
			for ( int countBucket = 0 ; countBucket < 10 ; countBucket++ ) {

				// Retrieve the ArrayList from a bucket
				ArrayList<Integer> temp = buckets[ countBucket ];

				// Place the numbers from bucket ArrayList into the main array
				for ( int num : temp ) {
					this.arr[ arrayIndex ] = num;
					arrayIndex++;	// Move to the next index in the main array
				}

			}

		}
	}
	
}