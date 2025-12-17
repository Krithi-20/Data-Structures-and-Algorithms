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
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {  //find middle node
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, temp;

        while(curr != null) {  // reverse 2nd LL
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;

        while(second.next != null) {  //merge two LL
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}