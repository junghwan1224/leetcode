package addTwoNumber;


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

/*
 * https://leetcode.com/problems/add-two-numbers/
 * */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode prev = result;
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int sum = 0;
			
			if(l1 != null && l2 != null) {
				sum = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			else if(l1 != null) {
				sum = l1.val + carry;
				l1 = l1.next;
			}
			else {
				sum = l2.val + carry;
				l2 = l2.next;
			}
			
			
			int val = sum % 10;
			carry = sum / 10;
			
			ListNode node = new ListNode(val);
			prev.next = node;
			prev = node;
		}
		
		if(carry > 0) {
			ListNode last = new ListNode(carry);
			prev.next = last;
		}
		
        return result.next;
    }
	
}
