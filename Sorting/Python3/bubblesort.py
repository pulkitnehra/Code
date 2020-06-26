def bubble_sort(arr):
	sort(arr)
	return arr

def sort(arr):
	for i in range(len(arr)):
		for j in range(i+1,len(arr)):
			if arr[i] > arr[j]:
				temp = arr[i]
				arr[i] = arr[j]
				arr[j] = temp

if __name__ == '__main__':
	array = [3,37,29,5,7,4,3,2,5,6,29,7,9,3,8,21,15,16,9,55,8,10,101,57,9,12]
	print('The Unsorted array is: ',array)
	bubble_sort(array)
	print('The Sorted array is: ',array)
