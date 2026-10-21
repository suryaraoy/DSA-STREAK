class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char[] ch=s.toCharArray();
        char min=ch[0];
        char max=ch[0];
        boolean sorted=true;
        for(int i=1;i<ch.length;i++){
            min=(char) Math.min(min,ch[i]);
            max=(char) Math.max(max,ch[i]);
            if(ch[i]<ch[i-1]) sorted=false;
        }
        if(sorted) return 0;
        if(n==2) return -1;
        if(ch[0]==min || ch[n-1]==max) return 1;
        for(int i=1;i<n-1;i++){
            if(ch[i]==min || ch[i]==max) return 2;
        }
        return 3;
    }
}