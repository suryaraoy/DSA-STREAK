class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int total=0;
        for(int i=0;i<n;i++){
           int c= s.charAt(i)-'a' + 1;
           total=total+((27-c)*(i+1));
        }
        return total;
    }
}