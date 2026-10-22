class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;

        int asc_order=0;
        int desc_order=0;
        for(int i=1;i<n;i++){
            if(nums[i]==(nums[i-1]+1)%n) asc_order++;;
            if(nums[i-1]==(nums[i]+1)%n) desc_order++;
        }
        if(asc_order==n-1 && nums[0]==0) return 0;

        if(asc_order==n-1){
            int left_rot=n-nums[0];
            int right_rot=1+(nums[n-1]+1)+1;
            return Math.min(left_rot,right_rot);
        }
        if(desc_order==n-1){
            int left_rot=1+(n-nums[n-1]);
            int right_rot=(nums[0]+1)%n+1;
            return Math.min(left_rot,right_rot);
        }
        return -1;
    }
}