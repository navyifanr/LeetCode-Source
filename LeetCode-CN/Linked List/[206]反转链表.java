//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //方法 1，使用栈
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        ListNode fakeHead = new ListNode(-1);
        ListNode temp = head;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        temp = fakeHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pollLast();
            temp = temp.next;
        }
        temp.next = null;
        return fakeHead.next;
    }

    //方法 2
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode node = curNode.next;
            curNode.next = preNode;
            preNode = curNode;

            curNode = node;
        }
        return preNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T2-7.10  > 20min
 */