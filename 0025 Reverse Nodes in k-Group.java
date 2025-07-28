class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode predecessor = dummyNode, current = dummyNode;

        while (current.next != null) {
            for (int i = 0; i < k && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                return dummyNode.next;
            }

            ListNode temp = current.next;
            current.next = null;
            ListNode start = predecessor.next;
            predecessor.next = reverseList(start);
            start.next = temp;
            predecessor = start;
            current = predecessor;
        }
        return dummyNode.next;
    }
    private ListNode reverseList(ListNode head) {
        ListNode previous = null, currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previous;
            previous = currentNode;
            currentNode = nextNode;
        }
        return previous;
    }
}
