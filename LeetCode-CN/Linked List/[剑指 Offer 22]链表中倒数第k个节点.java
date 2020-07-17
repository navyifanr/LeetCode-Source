//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针


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
    public ListNode getKthFromEnd(ListNode head, int k) {
        int steps = 1;
        ListNode slow = head, fast = head;
        while (steps < k && fast != null) {
            fast = fast.next;
            steps++;
        }
        if (steps != k) {
            return null;
        }
        while (fast.next != null) {  //注意，steps 只走 k -1 步
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //代码优化
    public ListNode getKthFromEnd(ListNode head, int k) {
        int steps = 0;
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (steps < k) {
                steps++;
            } else {
                slow = slow.next;
            }
        }
        if (steps != k) {
            return null;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
