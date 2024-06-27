package LinkedList;

public class DetectPalindrome {
    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        // Find the middle
        ListNode mid = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode new_head = reverseLL(mid);
        ListNode old_head = head;
        while(new_head != null){
            if(new_head.val != old_head.val){
                reverseLL(mid);
                return false;
            }
            new_head = new_head.next;
            old_head = old_head.next;
        }
        reverseLL(mid);
        return true;

    }
}
