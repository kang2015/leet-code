/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        Comparator<ListNode> comp = new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return Integer.compare(node1.val,node2.val);
            }
        };
        PriorityQueue<ListNode> pQue = new PriorityQueue<ListNode>(lists.length,comp);
        for(ListNode list:lists){
            if(list != null) pQue.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        while(pQue.size()>0){
            ListNode tmp =  pQue.poll();
            t.next = tmp;
            if(tmp.next != null){
                pQue.add(tmp.next);
            }
            t = t.next;
        }
        
        return dummy.next;
    }
}
