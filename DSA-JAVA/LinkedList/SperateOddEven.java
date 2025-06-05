package LinkedList;

public class SperateOddEven {

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        // get the ref to the end
        ListNode evenList = null;
        ListNode oddList = null;
        ListNode evenListTail = null;
        ListNode oddListTail = null;
        int count = 1;
        while (head != null){
            ListNode next = head.next;
            head.next = null;
            if(count%2 == 1){
                // add to the odd list
                if(oddList == null){
                    oddList = head;
                    oddListTail = head;
                } else{
                    oddListTail.next = head;
                    oddListTail = head;
                }
            } else{
                // add to the even list
                if(evenList == null){
                    evenList = head;
                    evenListTail = head;
                } else{
                    evenListTail.next = head;
                    evenListTail = head;
                }
            }

            head = next;
            count++;
        }
        if(oddListTail != null){
            oddListTail.next = evenList;
            return oddList;
        } else return evenList;
    }

    // Better way to code
    // [1, 2, 3, 4, 5]
    public ListNode oddEvenList2(ListNode head) {
        // return if the size of list is less than 2
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while(evenNode != null && evenNode.next != null){
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;

            evenNode = evenNode.next;
            oddNode = oddNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        // make a LinkedList : [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = oddEvenList(head);
        res.printList(res);
    }
}
