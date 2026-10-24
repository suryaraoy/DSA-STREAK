class Solution {
    public int totalDays(String combineDays,int[] cumMonth){
        int monthDays=Integer.parseInt(combineDays.substring(0,2));
        int remDays=Integer.parseInt(combineDays.substring(3));

        return cumMonth[monthDays-1]+remDays;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] cumMonth=new int[13];
        cumMonth[0]=0;
        for(int i=1;i<=12;i++){
            cumMonth[i]=month[i-1]+cumMonth[i-1];
        }

        int arriveAliceDay=totalDays(arriveAlice,cumMonth);
        int leaveAliceDay=totalDays(leaveAlice,cumMonth);
        int arriveBobDay=totalDays(arriveBob,cumMonth);
        int leaveBobDay=totalDays(leaveBob,cumMonth);

        int result=Math.min(leaveAliceDay,leaveBobDay)-Math.max(arriveBobDay,arriveAliceDay)+1;

        return result<0?0:result;
    }
}