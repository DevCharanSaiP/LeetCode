class Solution {
    public void reorderList(ListNode head) {
        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode current = slowPointer.next; // This is the start of the second half
        slowPointer.next = null; // Split the list into two
      
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        current = head; // Reset current to the start of the first half
      
        while (previous != null) {
           ListNode temp = previous.next;
            previous.next = current.next;
            current.next = previous;
            current = previous.next;
            previous = temp;
        }
    }
}
