class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = k1 + k2;
        int n = nums1.length;
        int maxDiff = 0;
        
        int[] diffs = new int[n];
        long totalDiffSum = 0;
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiffSum += diffs[i];
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        if (totalDiffSum <= k) return 0;
        
        int[] bucket = new int[maxDiff + 1];
        for (int d : diffs) {
            bucket[d]++;
        }
        
        for (int d = maxDiff; d > 0; d--) {
            if (bucket[d] > 0) {
                int take = (int) Math.min(k, bucket[d]);
                bucket[d] -= take;
                bucket[d - 1] += take;
                k -= take;
                
                if (k == 0) break;
            }
        }
        
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (bucket[d] > 0) {
                ans += (long) d * d * bucket[d];
            }
        }
        return ans;
    }
}
