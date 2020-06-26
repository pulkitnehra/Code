
import java.util.Arrays;
//	Time	 |  Space
//	O(n²)    |	O(n)
public class bubbleSort {

public static void main(String[] args) {
	int arr[] =  {3,37,29,5,7,4,3,2,5,6,29,7,9,3,21,15,16,9,55,10,101,57,9,12};
	
	System.out.println("The original array is: ");
	System.out.println(Arrays.toString(arr));
	System.out.println("\nThe Sorted array is: ");
	BubbleSort(arr);
	System.out.println(Arrays.toString(arr));
}

static void BubbleSort(int arr[])
{
	for(int i = 0; i<arr.length; i++)
	{
		for(int j = i+1; j<arr.length; j++)
		{
			if(arr[i] > arr[j])
			{
				swap(arr,i,j);
			}
		}
	}
}

static void swap(int arr[], int a, int b)
{
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;

}
}
