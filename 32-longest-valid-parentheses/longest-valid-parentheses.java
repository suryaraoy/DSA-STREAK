class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        int result=0;
        //Left To Right
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close) result=Math.max(result,open+close);
            else if(close > open){//left to right  --->
                open=0;
                close=0;
            }
        }
        //Right To Left
        open=0;
        close=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close) result=Math.max(result,open+close);
            else if(open > close){  //right to left  <---
                open=0;
                close=0;
            }
        }
        return result;
    }
}