class Solution {
    public int sortableIntegers(int[] nums) {
         int n = nums.length;
        int answer = 0;

        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                if (isSortable(nums, d)) {
                    answer += d;
                }
                int other = n / d;
                if (other != d) {
                    if (isSortable(nums, other)) {
                        answer += other;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isSortable(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += k) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            int descents = 0;

            for (int j = 0; j < k; j++) {
                int curr = nums[i + j];
                minVal = Math.min(minVal, curr);
                maxVal = Math.max(maxVal, curr);
                
                // Check descending transitions inside the block
                if (j > 0 && nums[i + j - 1] > curr) {
                    descents++;
                }
            }

            // Check circular transition (last element to first element of the block)
            if (nums[i + k - 1] > nums[i]) {
                descents++;
            }

            // A block can be sorted by cyclic rotation if it has at most 1 descent
            if (descents > 1) {
                return false;
            }

            // Ensure previous block's max does not exceed current block's min
            if (prevMax > minVal) {
                return false;
            }

            prevMax = maxVal;
        }

        return true;
    }
}