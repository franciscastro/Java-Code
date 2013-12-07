/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Shellsort algorithm
*	References: 
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*/

import java.util.*;
import java.io.File;

public class ShellSort extends SortingAlgorithm {

	public ShellSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		// Increment data
		int[] increments = { 4, 2, 1 };		// Set of increments
		int no_of_increments = increments.length;
		
		int current_increment, current_toBeSorted, position;

		/*
		*	Shellsort
		*	> increment_counter moves through the set of increments
		*	> move increment_counter to the next increment value for each loop
		*/
		for( int increment_counter = 0; increment_counter < no_of_increments; increment_counter++ ){

			current_increment = increments[ increment_counter ];	// Move to next increment in sequence
		
			/* 
			*	Insertion sort
			*	> initialize monitor to the first element after the first "bin"
			*	> move monitor to the next value to be evaluated
			*/
			for( int monitor = current_increment ; monitor < arr.length; monitor++ )
			{
				current_toBeSorted = arr[ monitor ];	// holds value to be evaluated, moved until correct position
				position = monitor;		// position of value to be evaluated
				
				// while position of current_toBeSorted is not the end AND current_toBeSorted is < the value in the "bin" to the left
				while( (position >= current_increment) && (current_toBeSorted < arr[ position-current_increment ]) )
				{
					// put greater value to [current]'s position (one place more)
					arr[ position ] = arr[ position-current_increment ];
					
					// next position of [current]
					position -= current_increment;	
				}
				
				// place [current value] in correct position (one place less)
				arr[position] = current_toBeSorted;
			}
			
		}
	}
	
}