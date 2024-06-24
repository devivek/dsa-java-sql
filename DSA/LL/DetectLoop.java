package LL;

public class DetectLoop {

    // Approach-1: Store the node in a set while traversing and detect if the node is already present in the set
    // Approach-2: Floyd's Cycle Detection Algorithm
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
         return false;
    }
}
