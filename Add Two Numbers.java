/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null,pre = null,tmp = null;
        int carry = 0,val = 0;
        while(l1 != null || l2 != null){
            val = carry;
            if(l1 != null){
                val += l1.val;
                l1 =l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2=l2.next;
            }
            tmp = new ListNode(val%10);
            carry = val/10;
            if(ans == null){
                ans = tmp;
            }else{
                pre.next = tmp;
            }
            pre = tmp;
            
        }
        if(carry == 1){
            pre.next = new ListNode(1);
        }
        return ans;
    }
}
