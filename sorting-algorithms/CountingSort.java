/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Counting sort algorithm
*	References: 
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*/

import java.util.*;
import java.io.File;

public class CountingSort extends SortingAlgorithm {

	public CountingSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{

		// ( Java automatically initializes int array elements to zero )
		// Find the maximum value in the input to determine the size of countArray[]
		int[] countArray = new int[ ( this.findMax() + 1 ) ];	// Increase size by 1 to accommodate zero

		// For keeping the sorted set of elements
		int[] sortedArray = new int[ this.n ];

		// Count the occurrences of each element in the input array
		for ( int monitor = 0; monitor < this.n ; monitor++ ) {
			countArray[ this.arr[ monitor ] ]++;
		}

		// Get a running sum of each count as we go through the countArray
		// Each element stands for the number of elements in arr[] that <= the ith element
		for (  int monitor = 1 ; monitor < countArray.length ; monitor++ ) {
			countArray[ monitor ] += countArray[ ( monitor - 1 ) ];
		}

		// Go through the array backwards to place the elements in sorted order,
		// decrementing the counts in countArray[] as we go along
		for ( int monitor = ( this.n - 1 ) ; monitor >= 0 ; monitor-- ) {

			sortedArray[ ( countArray[ this.arr[ monitor ] ] - 1 ) ] = this.arr[ monitor ];
			countArray[ this.arr[ monitor ] ] = ( countArray[ this.arr[ monitor ] ] - 1 );

		}

		// Copy sortedArray[] into arr[]
		this.arr = sortedArray;

	}

	private int findMax()
	{
		// Initialize maximum and minimum to the first element in the set
		int maximum = this.arr[ 0 ];

		// Look for the largest value
		for ( int i = 0 ; i < this.n ; i++ ) {
			if ( this.arr[ i ] > maximum ) {
				maximum = arr[ i ];
			}
		}

		return maximum;
	}
	
}