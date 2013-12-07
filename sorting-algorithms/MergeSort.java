/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Merge sort algorithm
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*/

import java.util.*;
import java.io.File;

public class MergeSort extends SortingAlgorithm {

	public MergeSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		this.mergeSort( 0, (n-1) );

	}

	private void mergeSort( int start, int end ){

		// If the start point < end point, this portion of the array is sorted
		if ( start < end ) {
		
			// Find the middle index of the current array
			int middle = start + ( ( end - start ) / 2 );
		
			// DIVIDE & CONQUER
			// Split into two sub-arrays and do recursive calls for each sub-array
			this.mergeSort( start, middle );		// Left sub-array
			this.mergeSort( ( middle + 1 ), end );	// Right sub-array

			// MERGE
			this.merge( start, middle, end );

		}

	}

	private void merge( int start, int middle, int end ){

		// Temporary arrays to hold left and right sub-arrays
		int[] left = new int[ middle + 1 ];
		int[] right = new int[ end - ( middle + 1 ) ];

		int leftCounter = start;			// Monitor starting index of left sub-array
		int rightCounter = (middle + 1);	// Monitor starting index of right sub-array
		int actualArrayCounter = start;		// Monitor index of actual array

		// While the index monitors for both sub-arrays have not reached their respective end indices...
		while ( (leftCounter < left.length) && (rightCounter < right.length) ) {
			
			// If current element of left sub-array < current element of right sub-array
			if ( left[ leftCounter ] < right[ rightCounter ]) {
				arr[ actualArrayCounter ] = left[ leftCounter ];
				leftCounter++;
			}
			// If current element of right sub-array < current element of left sub-array
			else {
				arr[ actualArrayCounter ] = right[ rightCounter ];
				rightCounter++;
			}

			// Move to next index in actual array
			actualArrayCounter++;

		}

		// Loop through the remaining contents of whichever sub-array still has remaining items
		while ( (leftCounter < left.length) || (rightCounter < right.length) ) {

			// If left sub-array has remaining items
			if ( leftCounter < left.length ) {
				arr[ actualArrayCounter ] = left[ leftCounter ];
				leftCounter++;
			}
			// If right sub-array has remaining items
			else {
				arr[ actualArrayCounter ] = right[ rightCounter ];
				rightCounter++;
			}

			// Move to next index in actual array
			actualArrayCounter++;

		}

	}
	
}