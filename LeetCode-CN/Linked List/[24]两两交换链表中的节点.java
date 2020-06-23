//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 时间复杂度O(n), 空间复杂度O(1)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode moveNode = fakeHead;
        ListNode tempNode = head;
        ListNode preNode = null, nextNode = null;
        while (tempNode != null) {
            if (preNode == null) {
                preNode = new ListNode(tempNode.val);
            } else if (nextNode == null) {
                nextNode = new ListNode(tempNode.val);
                nextNode.next = preNode;
                moveNode.next = nextNode;
                moveNode = moveNode.next.next;
                preNode = null;
                nextNode = null;
            }
            tempNode = tempNode.next;
        }
        if (preNode != null) {
            moveNode.next = preNode;
        }
        return fakeHead.next;
    }

    //优化版，利用节点交换，直接在原链表修改
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode preNode = fakeHead;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //交换节点
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            preNode = firstNode;
            head = firstNode.next;
        }
        return fakeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
