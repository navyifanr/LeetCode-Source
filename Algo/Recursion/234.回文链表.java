/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
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

    //方法1：参照后序遍历链表的思路，不足地方是会整个链表都会遍历一遍
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    // 方法2：查找中位节点
    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow, preSlow;
        fast = slow = head;
        preSlow = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }  //1-2-3-4-null
        if (fast != null) {
            preSlow = slow;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        ListNode oldRight = slow;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        if (preSlow != null) {
            preSlow.next = oldRight;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;
        next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end

