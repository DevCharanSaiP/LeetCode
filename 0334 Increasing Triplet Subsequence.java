class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int ele : nums) {
            if (ele <= first) {
                first = ele;  // Update the smallest element
            } else if (ele <= second) {
                second = ele; // Update the second smallest element
            } else {
                return true;  // Found a third element greater than first and second
            }
        }
        return false;
    }
}
