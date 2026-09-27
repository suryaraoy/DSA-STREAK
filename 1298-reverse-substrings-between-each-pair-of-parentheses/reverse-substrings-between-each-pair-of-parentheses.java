class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        Deque<Integer> qu=new ArrayDeque<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='(') qu.push(i);
            else if(s.charAt(i)==')'){
               int j=qu.pop();
               map.put(i,j);
               map.put(j,i);
            }
        }
        
    for (int i = 0, d = 1; i < s.length(); i += d)
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = map.get(i);
        d = -d;
      } else {
        sb.append(s.charAt(i));
      }

    return sb.toString();
    }
}