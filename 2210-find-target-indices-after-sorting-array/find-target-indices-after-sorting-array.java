class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<target) count++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]==target){
             list.add(count);
             count++;
            }
        }
        return list;
    }
}