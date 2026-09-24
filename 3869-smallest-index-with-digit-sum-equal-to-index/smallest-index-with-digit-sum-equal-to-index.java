class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        if(nums[0]==0) return 0;
      for(int i=0;i<n;++i){
        int sum=0;
        while(nums[i]>0){
            int last=nums[i]%10;
            sum=sum+last;
            nums[i]=nums[i]/10;
        }
         if(i==sum) {
                return i;
            }
      }
      return -1;
    }
}