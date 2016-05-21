/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head) {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            length ++;
        }
        return length;
     }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode seekA = headA;
        ListNode seekB = headB;
        int steps = 0;
        if (lengthA >= lengthB) {
            while (steps < lengthA - lengthB && seekB != null) {
                seekA = seekA.next;
                steps ++;
            }
        } else {
            while (steps < lengthB - lengthA && seekA != null) {
                seekB = seekB.next;
                steps ++;
            }
        }
        while (seekA != null && seekB != null) {
            if (seekA.equals(seekB)) {
                return seekA;
            } else {
                seekA = seekA.next;
                seekB = seekB.next;
            }
        }
        return null;
    }
}