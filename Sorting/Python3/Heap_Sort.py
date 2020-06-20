def heapSort(array):
    # Write your code here.
    sort(array)
    return array


def sort(array):
    n = len(array)

    # build max heap
    # start from n-1//2(// for int val) to -1(excluded) decrease -1 each iteration
    for i in range(n - 1 // 2, -1, -1):
        heapify(array, n, i)

    # Heap sort
    # bigger elements are placed first in the last places in an order
    for j in range(n - 1, -1, -1):
        # swap the root element with the last node then remove it
        temp = array[0]
        array[0] = array[j]
        array[j] = temp

        # after swapping remove the root node by settting i as size
        # again the heap will be checked for max heap
        # above process of swapping and removal takes place until
        # all the elements are perfectly sorted
        heapify(array, j, 0)

# to maintain the max-heap structure
def heapify(array, n, root_idx):
    largest = root_idx
    # left child
    left_child = 2 * root_idx + 1
    # right_child
    right_child = 2 * root_idx + 2

    # check which child is larger
    if left_child < n and array[left_child] > array[largest]:
        largest = left_child
    if right_child < n and array[right_child] > array[largest]:
        largest = right_child

    # check if root node is smaller
    if largest != root_idx:
        # means there is element larger than the root
        # swap that element with the root
        swap = array[root_idx]
        array[root_idx] = array[largest]
        array[largest] = swap

        # check if the max-heap structure is maintained
        # pass largest as root node to see if there is some
        # child greater than parent
        heapify(array, n, largest)

if __name__ == '__main__':
    arr = [3,56,7,9,1,12,5]
    print('Before sorting: ',arr)
    heapSort(arr)
    print("After sorting: ",arr)
