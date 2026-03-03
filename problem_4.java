
// This solution uses binary search on the smaller array to efficiently find the median of two sorted arrays in O(log(min(n, m))) time.

// Step 1: Choose smaller array  
// To minimize search space, the algorithm always performs binary search on the shorter array.

// Step 2: Partition both arrays

// partitionX splits the smaller array.

// partitionY is calculated so that the left side of both arrays combined has the same number of elements as the right side.

// Step 3: Identify boundary values

// l1 and r1 are left/right boundary values around partitionX.

// l2 and r2 are left/right boundary values around partitionY.

// Edge cases are handled using Integer.MIN_VALUE and Integer.MAX_VALUE.

// Step 4: Check correct partition  
// If l1 <= r2 and l2 <= r1, the partition is valid:

// If total length is even → median = average of max(l1, l2) and min(r1, r2).

// If odd → median = max(l1, l2).

// Step 5: Adjust search

// If l1 > r2, move search left (high = partitionX - 1).

// Else, move search right (low = partitionX + 1).

















class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          int smaller[] = nums1.length > nums2.length ? nums2 : nums1;
          int larger[] = nums1.length > nums2.length ? nums1 : nums2;
          int high = smaller.length;
          int low = 0;
          while (low <=high) {
               int partitionX = (low + high) / 2;
               int partitionY = (smaller.length + larger.length +1) / 2 - partitionX;
               int l1 = partitionX == 0 ? Integer.MIN_VALUE : smaller[partitionX - 1];
               int r1 = partitionX == smaller.length ? Integer.MAX_VALUE : smaller[partitionX];
               int l2 = partitionY == 0 ? Integer.MIN_VALUE : larger[partitionY - 1];
               int r2 = partitionY == larger.length ? Integer.MAX_VALUE : larger[partitionY];
               if (l1 <= r2 && l2 <= r1) {
                    if ((smaller.length + larger.length) % 2 == 0) {
                         return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    } else {
                         return Math.max(l1, l2);
                    }
               }
               if (l1 > r2) {
                    high = partitionX - 1;
               } else {
                    low = partitionX + 1;
               }

          }
          return 0.0;
     }
}
