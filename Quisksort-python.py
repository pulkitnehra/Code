# Quicksort main function
def quickSort(arr):
    # create a second function that will return the sorted array
    quickSrt(arr, 0, len(arr) - 1)
    return arr

def quickSrt(arr, left, right):
    i = left
    j = right
    mid = (left + right) // 2
    # Find the pivot
    pivot = arr[mid]
    
    # traverse the array till its end
    while i <= j:
        # divide the array into left and right subarray on basis of pivot
        
        # elements less than pivot
        while arr[i] < pivot:
            i += 1
            
        # elements greater than the pivot
        while arr[j] > pivot:
            j -= 1

        # After the successful execution of the above code we get our arrangement of left
        # and right subarrays in accordance with pivot

        """
            But there can exist a condition where arr[i] > pivot even before the index i < pivot
            In this case it will exit the loop and will create problems in sorting at the left subarray. 
            Same is the case with the right subarray where arr[j] < pivot
        """
        
        # To counter this we create a pass condition which will save us the hassle
        if i <= j:
            # swap the positions of elements at index i and j
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i += 1
            j -= 1

        # After this condition is executed, we will get our perfect arrangement

        """
            But, there is one more problem both the left and right subarray could or will contain
            elements that are unsorted. So we sort them and get the resultant sorted array
        """

        # Sorting left sub-array recursively
        if left < j:
            quickSrt(arr, left, j)
        # Sorting right sub-array recursively
        if i < right:
            quickSrt(arr, i, right)




if __name__ == '__main__':
   array1 = [2,23,4,56,9,1]
   print("Elements before quicksort: ",array1)
   quickSort(array1)
   print("\nElements after quicksort",array1)
