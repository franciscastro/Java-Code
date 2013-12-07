/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Insertion sort algorithm
*	References: 
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*/

import java.util.*;
import java.io.File;

public class InsertionSort extends SortingAlgorithm {

	public InsertionSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		
		int current, position;
		
		// Insertion sort
		for( int i = 1; i < arr.length; i++ )
		{
			current = arr[i];	// holds value to be evaluated, moved until correct position
			position = i;		// position of [current] value to be evaluated
			
			// while position of [current] is not the end (start of array) AND [current] is < the value to the left
			while( (position > 0) && (current < arr[position-1]) )
			{
				// put greater value to [current]'s position (one place more)
				arr[position] = arr[position-1];

				// next position of [current]
				position--;
			}
			
			// place [current value] in correct position (one place less)
			arr[position] = current;
		}
	}
	
}