class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
      
        ListNode previousNode = dummyNode;
        ListNode currentNode = head;
      
        while (currentNode != null && currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;
            previousNode.next = nextNode;
          
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
      
        return dummyNode.next;
    }
}
