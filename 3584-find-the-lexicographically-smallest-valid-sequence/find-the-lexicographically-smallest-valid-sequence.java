class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[] rightSideMatch=new int[n+1];
        int rightMatched=0;
        int i=n-1;
        int j=m-1;
        int size=0;

        while(i>=0){
            if(j>=0 && word1.charAt(i)==word2.charAt(j)){
                rightMatched++;
                j--;
            }
            rightSideMatch[i]=rightMatched;
            i--;
        }
        int[] sequence=new int[m];
        i=0;
        j=0;
        boolean powerChange=true;
        while(i<n && j<m){
            if(word1.charAt(i)==word2.charAt(j)){
                sequence[size++]=i;
                j++;
            }
            else if(powerChange==true && i+1<n && rightSideMatch[i+1]>=m-j-1){
                sequence[size++]=i;
                j++;
                powerChange=false;
            }
            i++;
        }
       if(j==m) {
        return sequence;
       }
       else {
        return new int[0];
       }
    }
}