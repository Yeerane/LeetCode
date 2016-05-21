/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead, evenHead;
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        } else {
            oddHead = head;
            evenHead = head.next;
            ListNode evenTail = evenHead;
            ListNode oddTail = oddHead;
            boolean isOdd = true;
            while (oddTail.next != null && evenTail.next != null) {
                if (isOdd) {
                    oddTail.next = evenTail.next;
                    oddTail = oddTail.next;
                } else {
                    evenTail.next = oddTail.next;
                    evenTail = evenTail.next;
                }
                isOdd = !isOdd;
            }
            oddTail.next = evenHead;
            evenTail.next = null;
            return head;
        }
    }
}