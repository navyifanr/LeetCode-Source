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
    //error，注意，排好序的，要衔接上
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode prev = head, cur = head.next;
//        head = cur;
//        while (cur != null) {
//            ListNode node = cur.next;
//            prev.next = node;
//            cur.next = prev;
//
//            prev = node;
//            if (node != null) {
//                cur = node.next;
//            } else {
//                break;
//            }
//        }
//        return head;
//    }

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
        ListNode prev = fakeHead, cur = head;
        while (cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;

            //交换节点
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            cur = first.next;
        }
        return fakeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-20.8.16, 20min
 */