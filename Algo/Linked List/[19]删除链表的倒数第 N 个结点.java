//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    // 方法1：
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        for (int i = 0; i < n + 1; i++) {
            if (fast == null) {  //注意，有可能是第一个节点
                return head.next;
            } else {
                fast = fast.next;
            }
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //方法2：
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fast = head;
//        int i = 0;
//        while (i++ < n) {  // 应该要找 n + 1
//            fast = fast.next;
//        }
//        ListNode slow = head;
//        ListNode fakeHead = new ListNode(-1);
//        fakeHead.next = slow;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return fakeHead.next;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        //找到倒数 n+1 节点，注意，传的是 fakeHead, 而不是 head, 否则如果删除第一个节点的情况会出现空指针异常
        ListNode node = findFromEnd(fakeHead, n + 1);
        //删掉 n 节点
        node.next = node.next.next;
        return fakeHead.next;
    }

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
