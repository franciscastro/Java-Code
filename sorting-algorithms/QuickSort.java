/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Quicksort algorithm
*	In this implementation, the pivot element selected is the first element in (sub)array
*	References: 
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*/

import java.util.*;
import java.io.File;

public class QuickSort extends SortingAlgorithm {

	public QuickSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		// First call to quicksort: pass the first and last indices
		this.quicksort( 0, ( n - 1 ) );

	}

	private void quicksort( int left, int right )
	{
		// If right and left index monitors have not crossed each other
		if ( right > left ) {
			
			// Partition the array with the pivot in the middle
			int pivot = this.partition( left, right );

			this.quicksort( left, pivot - 1 );	// Recursive call to quicksort on the left sub-array
			this.quicksort( pivot + 1, right );	// Recursive call to quicksort on the right sub-array

		}
	}

	// Partitioning the array:
	// Move all values < than pivot to the left, and all values > than pivot to the right
	private int partition( int left, int right )
	{
		int pivot = this.arr[ left ];	// Pivot is the leftmost value
		int left_monitor = left;		// Monitor the left side (increment later)
		int right_monitor = right + 1;	// Monitor the right side (decrement later)

		// Breaks when left_monitor and right_monitor crosses each other
		for (;;) {
			
			// Look for the index of a misplaced value (value > pivot) on the left sub-array
			while ( this.arr[ ++left_monitor ] < pivot ) {
				if ( left_monitor >= right ) {
					break;
				}
			}

			// Look for the index of a misplaced value (value < pivot) on the right sub-array
			while ( this.arr[ --right_monitor ] > pivot ) {
				if ( right_monitor <= left ) {
					break;
				}
			}

			// If left_monitor and right_monitor have crossed each other, break the loop
			if ( left_monitor >= right_monitor ) {
				break;
			}
			// Else swap between the values pointed to by {left,right}_monitor
			else {
				this.swap( left_monitor, right_monitor );
			}

		}

		// Return right_monitor if equal to the leftmost side
		if ( right_monitor == left ) {
			return right_monitor;
		}

		// Swap pivot and right_monitor value to place the pivot in the middle
		this.swap( left, right_monitor );

		return right_monitor;

	}

	// Swap values
	private void swap( int indexFromLeft, int indexFromRight )
	{
		int temp = arr[ indexFromLeft ];
		arr[ indexFromLeft ] = arr[ indexFromRight ];
		arr[ indexFromRight ] = temp;

	}
	
}