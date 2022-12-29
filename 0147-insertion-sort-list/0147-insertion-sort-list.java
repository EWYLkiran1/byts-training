class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyParent = new ListNode(0, head);
        ListNode headParent = dummyParent;
        while(head != null) {
            headParent = sort(dummyParent.next, head, dummyParent, headParent);
            head = headParent.next;
        }
        return dummyParent.next;
    }
    
    ListNode sort(ListNode start, ListNode end, ListNode startParent, ListNode endParent) {
        while(start != null && start != end) {
            if(end.val < start.val) {
                startParent.next = end;
                ListNode tempNode = end.next;
                end.next = start;
                endParent.next = tempNode;
                return endParent;
            }
            startParent = start;
            start = start.next;
        }
        return end;
    }
}