class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;

        int minIndex=0;
        int maxIndex=0;

        for(int i=1;i<n;i++){
           if(nums[i] < nums[minIndex]) minIndex=i;
           if(nums[i] > nums[maxIndex]) maxIndex=i;
        }
        int left=Math.min(minIndex,maxIndex);
        int right=Math.max(minIndex,maxIndex);
         
        int a=left+1+n-right;
        int b=right+1;
        int c=n-left;

        int min=a;

        if(min > b){
            min=b;
        }
        if(min > c) min=c;
        return min;
    }
}