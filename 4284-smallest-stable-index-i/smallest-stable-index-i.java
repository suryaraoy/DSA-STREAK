class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] minElementIndex=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            minElementIndex[i]=min;
        }
        int max=Integer.MIN_VALUE;
        int minElement=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            minElement=minElementIndex[i];
            if(max-minElement <= k) return i;
        }
        return -1;
    }
}