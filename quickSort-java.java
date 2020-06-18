package qkdrt;

import java.util.Arrays;

public class quickSort {
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {3,37,29,5,7,4,3,2,5,6,7,9};
		System.out.println("Before Sorting: ");
		for(int i = 0; i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		quicksort(arr,0,arr.length-1);
		System.out.println("\nAfter Sorting: ");
		for(int i = 0; i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		
	}
	
	
	static void quicksort(int[] arr, int left, int right)
	{

		int mid = (left + right)/2;
		
		int i = left;
		int j = right;
//		find pivot
		int pivot = arr[mid];
//		traversing the array
		while(i<=j)
		{
//			move elements less than the pivot to the left subarray
			while(arr[i] < pivot)
			{
				i++;
			}
//			move elements less than the pivot to the right subarray
			
			while(arr[j] > pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
//			sorting the left subarray
//			low to j 
//			i to right
			
			if(left<j)
			{
				quicksort(arr,left,j);
			}
			
			if(i<right)
			{
				quicksort(arr,i,right);
			}
		
		}
		
	
	
	}
	

}
