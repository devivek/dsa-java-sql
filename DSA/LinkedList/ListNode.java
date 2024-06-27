package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void printList(ListNode res) {
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
