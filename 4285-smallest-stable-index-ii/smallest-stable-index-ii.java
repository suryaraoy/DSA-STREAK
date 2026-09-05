class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int minElement=Integer.MAX_VALUE;
        int[] minElementIndex=new int[n];
        for(int i=n-1;i>=0;i--){
            minElement=Math.min(minElement,nums[i]);
            minElementIndex[i]=minElement;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
                max=Math.max(max,nums[i]);
                if(max-minElementIndex[i]<=k) return i;
        }
        return -1;
    }
}