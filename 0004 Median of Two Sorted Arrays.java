class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int leftPartitionSize = (m + n + 1) / 2; // Number of elements in left partition
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;  // Partition index for nums1
            int partitionY = leftPartitionSize - partitionX;  // Partition index for nums2

            // Get max left and min right values
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if the partition is valid
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total length is even, return average of two middle elements
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else { // If odd, return the middle element
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;  // Move left
            } else {
                low = partitionX + 1;  // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }
}
