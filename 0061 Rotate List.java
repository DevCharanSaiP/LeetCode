class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        k %= length;
      
        if (k == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
      
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
