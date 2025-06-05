package LinkedList;

public class DetectLoop {

    // Approach-1: Store the node in a set while traversing and detect if the node is already present in the set

    // Approach-2: Floyd's Cycle Detection Algorithm
    // fast - 2 steps
    // slow - 1 steps
    // delta (fast - slow) = 1
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                return true;
        }
         return false;
    }

    // after the loop detection, the distance between slow/fast point to the start is same as the distance of head to the intersection point
    // return the node where the cycle begins
    // PROOF
    // x is the length of loop
    // d is the distance between fast and slow when slow points towards the starting of loop
    // distnace between slow and fast = x-d
    // slow = 0; fast = d;
    // AFTER (x-d)
    // slow = (x-d); fast = d + 2*(x-d) = 2*x-d = x-d [due to loop] => PROVED

    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


}
