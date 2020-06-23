//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
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
 *  时间复杂度：O(n*k)，最好 O(n)，最差O(n^2)，空间复杂度：O(1)
 *
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;
        ListNode fakeHead = new ListNode(-1);
        ListNode newNode = fakeHead;
        ListNode tempNode = head;
        ListNode subNode = new ListNode(-1);
        ListNode subTmp = subNode;
        while (tempNode != null) {
            subTmp.next = new ListNode(tempNode.val);
            subTmp = subTmp.next;
            tempNode = tempNode.next;
            if (--count == 0) { //注意，保留原来的头结点
                newNode.next = reverseListNode(subNode.next);
                //注意重置 subNode
                subNode = new ListNode(-1);
                subTmp = subNode;
                int tmpK = k;
                while (tmpK-- > 0 && newNode != null) {
                    newNode = newNode.next;
                }
                count = k;  //注意恢复为 k
            }
        }
        if (count != 0) {
            newNode.next = subNode.next;
        }
        return fakeHead.next;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = null;
        while (head != null) {
//            ListNode newNode = head;
            ListNode newNode = new ListNode(head.val); //注意链表一定要创建新节点，否则会将原节点修改掉了
            newNode.next = result;
            result = newNode;
            head = head.next;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
