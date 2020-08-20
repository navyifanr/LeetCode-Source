//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        //合并两个有序的链表
        ListNode fakeHead = new ListNode(-1);
        ListNode temp = fakeHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right : left;
        return fakeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-20.8.16, 12min
 */