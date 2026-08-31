/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int index=1;
        ListNode prev=head;
        ListNode curr=prev.next;
        ArrayList<Integer> list=new ArrayList<>();

        while(curr.next!=null){
            ListNode next=curr.next;

            boolean localMinima=curr.val < prev.val && curr.val < next.val;
            boolean localMixima=curr.val > prev.val && curr.val > next.val;

            if(localMinima || localMixima) list.add(index);

            prev=curr;
            curr=next;
            index++; 
        }
        if(list.size()<2) return new int[]{-1,-1};
        int minDistance=Integer.MAX_VALUE;

        for(int i=1;i<list.size();i++){
            int distance=list.get(i)-list.get(i-1);

            minDistance=Math.min(distance,minDistance);
        }
        int maxDistance=list.get(list.size()-1)-list.get(0);
        return new int[]{minDistance,maxDistance};
    }
}