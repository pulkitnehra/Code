package Sorting;
// Time(all cases)		 | Space
//O(n*log(n) 			 | O(1)
public class HeapSort {
	public static void main(String[] args) {
		int arr[] = {3,37,29,5,7,4,3,2,5,6,29,7,9,3,8,21,15,16,9,55,8,10,101,57,9,12};
		System.out.println("Before heapsort the array is: ");
		printlist(arr);
		sort(arr);
		System.out.println("\nAfter heap sort the array is: ");
		printlist(arr);
	}
	
	static void printlist(int arr[])
	{
		for(int nums : arr)
		{
			System.out.print(nums+" ");
		}
	}
	
	
	
	static void sort(int arr[])
	{
//		to sort the elements
		int n = arr.length;
// 		build max heap
		for(int i = n/2 - 1 ;i>=0; i--)
		{
//			i=n/2-1 as it will give us the left and right child nodes at the first level of the heap
			heapify(arr,n,i);
		}
		
//		heap sort arranges the elements in the reverse ascending order the bigger elements occupy the last places and we get our sorted elements
		for(int j = n-1; j>=0; j--)
		{
//			swap the root node from the last element of heap and remove the root node from the heap
			
			int temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			
//			this function will have size 5 instead of 6 and will remove the largest element from the heap to initiate heapsort
//			this will continue until j = 0 i.e. only one element is left and one element is sorted in itself.
//			therefore we have the sorted list
			heapify(arr,j,0);
		}
		
		
	}
	
	
	static void heapify(int [] arr, int n, int root)
	{
//		maintain the max-heap structure
//		to keep track of the original index of root  we create another index and to comapre
//		if there is any element in the heap greater than the root
		int largest = root;
//		left child node
		int left = 2 * root + 1;
//		right child node
		int right = 2 * root + 2;
		
//	check if the left child is greater than the root node
		if(left < n && arr[left] > arr[largest])
		{
			largest = left;
		}
	
//		check if right child is greater
		if(right < n && arr[right] > arr[largest])
		{
			largest = right;
		}
	
// 		compare the current root value with the largest value
// 		if root is greater then continue if not then swap that node with root
		if(largest != root)
		{
//			if the index of the largest node is not root then swap largest with the root
			int swap = arr[root];
			arr[root] = arr[largest];
			arr[largest] = swap;

//		now check if there is any element greater than the second greatest element in the array
//			if there is that means parent node is smaller so to maintain maz-heap we heapify\
			heapify(arr, n ,largest);		
			
		}
//		above condition willnot execute when we have max-heap structure maintained i.e. 
//		if the parent nodes is greater than the child node and root node is the largest i.e when largest = 0
	
	
	
	}
	
	

}
