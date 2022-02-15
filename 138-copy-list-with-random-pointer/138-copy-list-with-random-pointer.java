/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
          Node curr = head; 
          Node front = head;
          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (curr != null) {
            front = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = front;
            curr = front;
          }
          // Second round: assign random pointers for the copy nodes.
          curr = head;
          while (curr != null) {
            if (curr.random != null) {
              curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
          }
          // Third round: restore the original list, and extract the copy list.
          curr = head;
          Node pseudoHead = new Node(0);
          Node copy = pseudoHead;

          while (curr != null) {
            front = curr.next.next;
            // extract the copy
            copy.next = curr.next;
            copy = copy.next;
            // restore the original list
            curr.next = front;
            curr = front;
          }
          return pseudoHead.next;
    }
}