class Solution {
    public int sortPermutation(int[] nums) {
        // Initialize ans to -1 (all bits set to 1 in 32-bit two's complement integer)
        int ans = -1;
        boolean misplaced = false;

        for (int i = 0; i < nums.length; ++i) {
            // Check if the current element is not in its correct sorted position
            if (nums[i] != i) {
                ans &= nums[i];
                misplaced = true;
            }
        }

        // If no elements were misplaced, the array is already sorted, return 0.
        // Otherwise, return the cumulative bitwise AND result.
        return misplaced ? ans : 0;
    }
}
