class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int total=0;
        for(int i=0;i<n;i++){
           int c= s.charAt(i)-'a' + 1;
           int reverse= 27-c;
           int product=reverse*(i+1);
           total+=product;
        }
        return total;
    }
}