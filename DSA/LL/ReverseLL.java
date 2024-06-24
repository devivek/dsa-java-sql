package LL;

public class ReverseLL {
    // [1 -> 2 -> 3 -> null_1] => [3 -> 2 -> 1 -> null_2]
    // [1 -> 2 -> 3 -> null ] => [ 1 <- 2   3]

    // Iterative Solution
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Recursive Solution
    // [1 -> 2 -> 3 -> null]
    public ListNode recursiveFlip(ListNode curr, ListNode prev) {
        if (curr == null)
            return prev;

        ListNode result = recursiveFlip(curr.next, curr);
        curr.next = prev;
        return result;
    }

    public ListNode reverseListByRecursion(ListNode head) {
        return recursiveFlip(head, null);
    }
}
