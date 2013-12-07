/**
*	Author: Francisco Enrique Vicente G. Castro
*	Program Description: An implementation of the Heap sort algorithm
*	References: 
*	Albacea, E.A. (2007). Design and Analysis of Algorithms: An Introduction (3rd ed.). Institute of Computer Science, University of the Philippines Los Banos.
*	Weiss, M.A. (1993). Data Structures and Algorithm Analysis in C. The Benjamin/Cummings Publishing Company, Inc. California.
*/

import java.util.*;
import java.io.File;

public class HeapSort extends SortingAlgorithm {

	public HeapSort( int[] arr, int n)
	{
		super( arr, n ); 
	}

	public void sort()
	{
		this.heapsort( n );
	}
	
	private void heapsort( int heapSize )
	{
		this.buildHeap( heapSize );

		for ( int count = (n - 1); count >= 0 ; count-- ) {
			this.swap( 0, count );
			this.restoreheap( 0, count );
		}

	}

	// Called to satisfy heap property of input heap (array)
	private void buildHeap( int heapSize )
	{
		// Index of the last node in the heap with a child
		int lastNodeWithChild = ( heapSize / 2 ) - 1;

		// Restore heap property from the last node with a child up to the root
		for ( int currentNode = lastNodeWithChild ; currentNode >= 0 ; currentNode-- ) {

			this.restoreheap( currentNode, heapSize );

		}

	}

	private void restoreheap( int nodeIndex, int heapSize )
	{

		int currentLargest = 0;
		int leftChild = ( ( 2 * nodeIndex ) + 1 );
		int rightChild = ( ( 2 * nodeIndex ) + 2 );

		// Check if index of left child is not out of bounds
		if ( leftChild < heapSize ) {
			
			// Check if the value of the left child is larger than the value of the node
			if ( arr[ leftChild ] > arr[ nodeIndex ] ) {
				currentLargest = leftChild;
			}
			else {
				currentLargest = nodeIndex;
			}

			// Check if index of right child is not out of bounds
			if ( rightChild < heapSize ) {
				
				// Check if the value of the right child is larger than the value of the node
				if ( arr[ rightChild ] > arr[ currentLargest ] ) {
					currentLargest = rightChild;
				}

			}

			// If the largest node is either the left or the right child
			if ( currentLargest != nodeIndex ) {
				this.swap( nodeIndex, currentLargest );
				this.restoreheap( currentLargest, heapSize );
			}

		}

	}

	// Swap values
	private void swap( int nodeIndex, int indexOfLarger )
	{
		int temp = arr[ nodeIndex ];
		arr[ nodeIndex ] = arr[ indexOfLarger ];
		arr[ indexOfLarger ] = temp;

	}
	
}