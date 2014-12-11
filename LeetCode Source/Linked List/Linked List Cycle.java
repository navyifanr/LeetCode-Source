/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

//首先要注意空链表不成环;不能开额外的空间，即空间复杂度是o(1),可采用“快慢指针”查检查链表是否含有环，如果在快的指针能够追上慢的指针，则有环，否则无环。
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){  //只要判断快指针是否为空就可以了，但是注意当fast是为结点时，fast.next为空，若判断fast.next.next则会报NullPointerException
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}