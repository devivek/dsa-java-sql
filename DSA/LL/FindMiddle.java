package LL;

public class FindMiddle {

    // Given the head of a singly linked list, return the middle node of the linked list
    // If there are two middle nodes, return the second middle node.

    // Brute Force: Traverse once and find the number of element and get the middle element in second traversal
    // Approach-2: TortoiseHare Method
    // In-case of even number of element, slow will point to null after the traversal
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

}
