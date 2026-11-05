class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;

        for(int i=0;i<arr1.length;i++){
            int arr=arr1[i];
            boolean valid=true;
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr-arr2[j])<=d){
                       valid=false;
                       break;
                }
            }
            if(valid) count++;
        }
        return count;
    }
}