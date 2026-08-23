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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode curr = head;
        while(curr != null && curr.next != null && curr.next.next != null){
            ListNode nextNode = curr.next;
            ListNode lastNode = f(nextNode);
            curr.next = lastNode;
            lastNode.next = nextNode;
            curr = nextNode;
        }
    }
    public ListNode f(ListNode head){
        if(head.next == null) return head;
        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        ListNode reqNode = temp.next;
        temp.next = null;
        return reqNode;
    }
}
