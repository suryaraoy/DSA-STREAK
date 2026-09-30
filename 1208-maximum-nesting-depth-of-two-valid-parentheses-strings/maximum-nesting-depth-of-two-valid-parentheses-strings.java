class Solution {
    public int[] maxDepthAfterSplit(String seq) {
       int n=seq.length();
       int depth=0;
       int[] result=new int[n];

       for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                depth++;
                result[i]=depth%2;
            }
            else{
                result[i]=depth%2;
                depth--;
            }
       }
       return result;
    }
}