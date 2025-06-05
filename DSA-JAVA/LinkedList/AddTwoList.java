package LinkedList;

public class AddTwoList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null && l2 != null){
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode node = new ListNode(val, null);

            if(head == null){
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode node = new ListNode(val, null);

            if(head == null){
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode node = new ListNode(val, null);

            if(head == null){
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry, null);

            if(head == null){
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }

    // the above code could be written in more concise way
}
