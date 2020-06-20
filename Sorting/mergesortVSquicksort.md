# 1 Introduction

Sorting:-

Arranging the data into either ascending or descending order.

Why?

**Sorting** arranges data in a sequence which makes searching easier



# 2 Sorting Criteria

The two main criteria to judge which sorting algorithm is better than the other have been:

1.Time taken to sort the given data.

2.Memory Space required to do so



# 3 Difference

**Quick Sort**

- We first select a pivot element and then divide the original subarray into left and right subarray.
- After first division of the array into left and right subarrays  we use partitioning technique on both the left and the right subarrays(selecting a pivot and repeat the process until all elements are sorted in the given list . 
- When all of these operations have been successfully performed we get the sorted resultant array

- *Time complexity*:

  **O(n log(n))** 

  **O(n²)** for worst case in case of unbalanced subarrays

- *Space Complexity*

  **O(n*log(n))**:- log(n) for partition and O(n) for traversing the subarrays



**Merge sort**

- In this, we first find the middle element = (left + right)/2 and then divide the array into subarrays.
- After the first division the subarrays keep on dividing until there is element left at the end. As we know one element is sorted in itself therefore we combine these lone one element subarrays to the nearest similar subarray. This process continues until we have two large left and the right subarrays 
- During this process there can be some elements in then subarrays that are comparable to each other at the time of merging, so with merging the subarrays we perform the sorting of the subarrays too.
-  Now for the two large subarrays this condition can also arise so we follow the same procedure as before and  merge and sort the array. Then at the end we get the sorted resultant array of the subarray.

- *Time complexity*

  **O(n log(n))**  for all cases

- *Space Complexity*

  **O(n)**:- because it will require the same space as the unsorted array 



# Advantages and disadvantages



1. **Quick sort** uses partitioning technique to divide the array into two subarrays and uses the same technique in those subarrays too to sort the elements so the space required for quicksort is only *O(nlog(n))* whereas since we keep on dividing the subarrays until there is one element left **merge sort** will require more space than quick sort i.e. *O(n)* require space equal to the unsorted array.
2. Because **quick sort** uses partitioning technique it could lead to unbalanced arrays(for ex there are no elements on the left side of pivot and elements are only greater and are on the right side of pivot and this will lead to more unbalanced arrays and if this continues then we will get the running time could be worst i.e. *O(n² ))*. But in case of **merge sort** the time complexity would always be *O(nlog(n))*as it takes linear time to divide and merge the subarrays.
3. **Quick sort** is an unstable sorting technique i.e.  it might change the occurrence of two similar elements in the array while sorting. Whereas **merge sort** is a stable algorithm i.e. it doesn't change the occurrence of similar elements(i.e"equal" elements are ordered in the same order in the sorted list.) preserve the order in which these elements appeared in the original array.
4. Because **merge sort** requires more space *O(n)* it is not desirable to use merge sort on large unsorted arrays in these cases **quick sort** *O(nlog(n))* is a better alternative.
5. Merge Sort is best for sorting Linked List and quicksort for large unsorted arrays provided there are less unbalanced subarrays. However in normal situations we can use any of them as they will give the same time complexity under normal cases.





