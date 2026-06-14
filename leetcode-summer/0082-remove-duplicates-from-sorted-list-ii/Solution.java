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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            boolean duplicate = false;

            // Check whether the current value appears more than once
            while (cur.next != null && cur.val == cur.next.val) {
                duplicate = true;
                cur = cur.next;
            }

            if (duplicate) {
                // Skip all nodes with the duplicated value
                prev.next = cur.next;
            } else {
                // Keep this node because it is unique
                prev = prev.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}