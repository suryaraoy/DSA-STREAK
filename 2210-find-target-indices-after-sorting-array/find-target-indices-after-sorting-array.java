class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small=0;
        int count=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target) small++;
            if(nums[i]==target) count++;
        }
        for(int i=0;i<count;i++){
            list.add(i+small);
        }
        return list;
    }
}