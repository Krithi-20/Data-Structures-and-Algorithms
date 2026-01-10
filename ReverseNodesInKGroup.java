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
class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ktail = dummy;
        ListNode ptr = head;

        while (true) {
            int count = 0;
            ptr = ktail.next;

            // check if k nodes exist
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }
            if (count < k) break;

            // reverse k nodes
            ListNode newHead = reverse(ktail.next, k);

            ListNode tail = ktail.next;
            ktail.next = newHead;
            ktail = tail;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;
        return prev;
    }
}
