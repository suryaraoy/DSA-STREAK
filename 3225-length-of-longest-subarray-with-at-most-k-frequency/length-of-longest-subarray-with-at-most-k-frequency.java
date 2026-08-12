class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=0;

        while(i < nums.length){
            int num=nums[i];
            map.put(num,map.getOrDefault(num,0)+1);

        while(map.get(num)>k){
            int start=nums[j];
            int freq=map.get(start);
            map.put(start,freq-1);
            j++;
        }
         max=Math.max(max,i-j+1);
         i++;
        }
       
        return max;
    }
}