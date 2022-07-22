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
class Solution {
   public ListNode partition(ListNode head, int x) {
		ListNode dummyBefore = new ListNode(-1);
		ListNode dummyAfter = new ListNode(-1);
		ListNode before = dummyBefore, after = dummyAfter;

		while(head != null){
             if(head.val < x){   //small list
				 before.next = head;
				 head = head.next;
				 before = before.next;
			 } else {            //high list
				 after.next = head;
				 head = head.next;
				 after = after.next;
			 }
		}
        after.next=null;
		before.next = dummyAfter.next;
		return dummyBefore.next;
	}
}