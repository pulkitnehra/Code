def insertion_sort(arr):
	sort(arr)
	return arr

def sort(arr):
	for step in range(1, len(array)):
	        key = array[step]
	        j = step - 1
	        # Compare key with each element on the left of it until an element smaller than it is found
	        # For descending order, change key<array[j] to key>array[j].        
	        while j >= 0 and key < array[j]:
	            array[j + 1] = array[j]
	            j = j - 1
	        # Place key at after the element just smaller than it.
	        array[j + 1] = key

if __name__ == '__main__':
	array = [3,37,29,5,7,4,3,2,5,6,29,7,9,3,8,21,15,16,9,55,8,10,101,57,9,12]
	print('The Unsorted array is: ',array)
	insertion_sort(array)
	print('The Sorted array is: ',array)
