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
    public ListNode reverseKGroup(ListNode head, int k) {
      
        ListNode dummy = new ListNode(-1,head);
        ListNode temp=head;
        ListNode start=dummy;
        int i=0;
        while(temp!=null) {
            i++;
            if(i%k==0) {
                start=reverse(start,temp.next);
                temp=start.next;
            } else {
                temp=temp.next;
            }
            
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start,ListNode end) {
        ListNode prev=null;
        ListNode head=start.next;
        ListNode first = head;
        while(head!=end) {
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        start.next=prev;
        first.next=head;
        return first;
    }

    }
