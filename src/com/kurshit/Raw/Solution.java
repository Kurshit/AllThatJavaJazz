package com.kurshit.Raw;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {

	public void addLast(ListNode res, int sum) {

		ListNode ptr = res;

		if(ptr == null) {
			res = new ListNode(sum);
			return;
		}

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = new ListNode(sum);



	}


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(l1 == null) {
			return l2;
		}    

		if(l2 == null) {
			return l1;
		}

		ListNode result = null;
		int sum = 0;
		int carry = 0;

		while(l1 != null || l2 != null) {

			int first = l1 != null ? l1.val : 0;
			int second = l2 != null ? l2.val : 0;

			sum = first + second + carry;

			if(sum >= 10)
				carry = 1;
			else 
				carry = 0;

			sum = sum % 10;

			addLast(result,sum);

			if(l1 != null)
				l1 = l1.next;

			if(l2 != null)
				l2 = l2.next;

		}

		if(carry > 0)
			addLast(result,1);

		return result;

	}
}