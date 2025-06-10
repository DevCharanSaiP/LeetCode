class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
      
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.offer(head);
            }
        }
        
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
      
        while (!priorityQueue.isEmpty()) {
            ListNode smallestNode = priorityQueue.poll();
          
            if (smallestNode.next != null) {
                priorityQueue.offer(smallestNode.next);
            }
          
            current.next = smallestNode;
            current = current.next;
        }
      
        return dummyHead.next;
    }
}
