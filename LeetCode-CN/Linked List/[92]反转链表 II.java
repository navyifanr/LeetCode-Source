//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {  // m==n 不需要反转
            return head;
        }
        ListNode preNode = null, curNode = head;
        while (m > 1) {
            preNode = curNode;
            curNode = curNode.next;
            m--;
            n--;
        }
        ListNode preList = preNode, tailNode = curNode, temp = null;
        preNode = null;
        while (n > 0) {
            temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
            n--;
        }
        if (preList != null) {
            preList.next = preNode;
        } else { //注意，如果 m 从第一个节点开始，最终要将 preNode 赋值给 head
            head = preNode;
        }
        tailNode.next = curNode;
        return head;
    }

    //初始写法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {  // m==n 不需要反转
            return head;
        }
        ListNode preNode = null, curNode = head, tail = null, prev = null;
        int i = 1;
        while (curNode != null) {
            if (i + 1 == m) {
                prev = curNode;
            }
            if (i >= m && i <= n) {
                ListNode node = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = node;
                if (i == m) {
                    tail = preNode;
                }
                if (i == n) {
                    if (prev != null) {
                        prev.next = preNode;
                    } else {  //注意，如果 m 从第一个节点开始，最终要将 preNode 赋值给 head
                        head = preNode;
                    }
                    if (curNode != null) tail.next = curNode;
                    break;
                }
            } else {
                curNode = curNode.next;
            }
            i++;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-20.8.16, >30min
 */