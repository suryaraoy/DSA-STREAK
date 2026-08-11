class Solution {
    public int missingInteger(int[] nums) {
        int sequential=nums[0];
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[j-1]+1){
                sequential+=nums[j];
            }
            else break;
        }
        HashSet<Integer> set=new HashSet<>();
      for(int n : nums){
        set.add(n);
      }
        while(set.contains(sequential)){
            sequential++;
        }
        return sequential;
    }
}