class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        int n=nums1.length;
        for(int i=1;i<n;i++){
            if(nums1[i]<min) min=nums1[i];
        }
        // convert all elements is odd
        //check if smallest element is odd then we can make every element in nums2 is odd
        if(min%2==1) return true;
        
        //convert all elements is even if possible
        //if one element is odd we can't convert every element even in nums2
        for(int nums2 : nums1){
            if(nums2 % 2 ==1) return false;
        }

        //then else condition so all elements present is nums1 is even 
        return true;

    }
}