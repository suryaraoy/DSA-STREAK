class Solution {
    public int totalNumbers(int[] digits) {
       int[] freq=new int[10];
       for(int digit : digits){
        freq[digit]++;
       }
       int count=0;

       for(int i=100;i<999;i++){
            if(i%2!=0){
                continue;
            }
            int num=i;
            int a=num%10;
            num=num/10;
            int b=num%10;
            num=num/10;
            int c=num%10;
        
        int[] need =new int[10];
        need[a]++;
        need[b]++;
        need[c]++;

        boolean possible =true;

        for(int d=0;d<=9;d++){
            if(need[d]> freq[d]){
                possible =false;
                break;
            }
        }
        if(possible){
            count++;
        }
       }
   return count;
    }
}