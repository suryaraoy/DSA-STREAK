class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        long min=0;
        for(int i=0;i<n/2;i++){
            min+=nums[i];
        }
        long max=0;
        for(int i=n/2;i<n;i++){
            max+=nums[i];
        }
        return max-min;
    }
}