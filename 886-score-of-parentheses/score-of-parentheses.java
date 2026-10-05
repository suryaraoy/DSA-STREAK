class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int score=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stack.push(score);
                score=0;
            }
            else{
                if(s.charAt(i-1)=='('){
                    score=stack.pop()+1;
                }
                if(s.charAt(i-1)==')'){
                    score=stack.pop()+score*2;
                }
            }
        }
        return score;
    }
}