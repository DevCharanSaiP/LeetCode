class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode previous = null;
        ListNode current = slow;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        ListNode firstHalfIterator = head;
        ListNode secondHalfIterator = previous;

        while (secondHalfIterator != null) {
            if (secondHalfIterator.val != firstHalfIterator.val) {
                return false;
            }
            secondHalfIterator = secondHalfIterator.next;
            firstHalfIterator = firstHalfIterator.next;
        }
        return true;
    }
}
