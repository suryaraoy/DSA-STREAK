class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        int n=nums1.length;
        for(int i=1;i<n;i++){
            if(nums1[i]<min) min=nums1[i];
        }
        if(min%2==1) return true;

        for(int nums2 : nums1){
            if(nums2 % 2 ==1) return false;
        }
        return true;

    }
}