//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 迭代法，时间复杂度：O(n) 或 O(m) 取最小的，空间复杂度 O(1)
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode tempNode = fakeHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tempNode.next = l2;
                break;
            }
            if (l2 == null) {
                tempNode.next = l1;
                break;
            }
//            //无需创建新节点，不然增加空间复杂度
//            ListNode node = new ListNode(Math.min(l1.val, l2.val));
//            tempNode.next = node;
//            tempNode = tempNode.next;
            if (l1.val <= l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        return fakeHead.next;
    }

    //递归法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


/*
T2-7.10  迭代法 >15min
 */