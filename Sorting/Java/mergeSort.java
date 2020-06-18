import java.util.Arrays;

public class MergeSort {
	//take note when inserting elements from original array to left and right sub arrays

	public static void main(String[] args) {
		int arr[] =  {3,37,29,5,7,4,3,2,5,6,7,9,1};
		System.out.println("Before Sorting: "+Arrays.toString(arr));
		
    sort(arr,0, arr.length-1);//sorts and merge the array
	  System.out.println("\nThe Sorted array is: ");
		
    for(int i =0; i<arr.length;i++)  
		{  
		    System.out.print(arr[i]+" ");  
		}  
			
		

	}
  
	static void mergeS(int Arr[], int start, int mid, int end) {

	// create a temp array
	int temp[] = new int[end - start + 1];

	// crawlers for both intervals and for temp
	int i = start, j = mid+1, k = 0;

	// traverse both arrays and in each iteration add smaller of both elements in temp 
	while(i <= mid && j <= end) {
		if(Arr[i] <= Arr[j]) {
			temp[k] = Arr[i];
			k ++; i ++;
		}
		else {
			temp[k] = Arr[j];
			k ++; j ++;
		}
	}

	// add elements left in the first interval 
	while(i <= mid) {
		temp[k] = Arr[i];
		k ++; i ++;
	}

	// add elements left in the second interval 
	while(j <= end) {
		temp[k] = Arr[j];
		k ++; j ++;
	}

	// copy temp to original interval
	for(i = start; i <= end; i += 1) {
		Arr[i] = temp[i - start];
	}
}
	 
	public static void sort(int[] arr, int beg, int end)
	{
		if(beg<end)
		{
			int mid = (beg+end)/2;
			//sort the left sub array
			sort(arr,beg,mid);
			
			//sort the right sub array
			sort(arr,mid+1,end);
			
			//merge the two subarrays
			mergeS(arr,beg,mid,end);
		}
	}	


}
