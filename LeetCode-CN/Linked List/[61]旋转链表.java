//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
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
    //方法 1：穷举法，一步一步移动最后节点到头部
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        int len = 0;
        while (curNode != null) {
            curNode = curNode.next;
            len++;
        }
        k = k % len;
        while (k-- > 0) {
            curNode = head;
            while (curNode.next.next != null) curNode = curNode.next;   //找到最后一个节点
            curNode.next.next = head;  //将最后一个节点指向头部
            head = curNode.next;       //修改头部节点
            curNode.next = null;       //修改最后一个节点
        }
        return head;
    }

    //方法 2：快慢指针，注意要先处理完移动 k 位
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            if (fast != null && fast.next != null) {
                fast = fast.next;
            } else {
                fast = head;
            }
        }
        if (slow == fast) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head; //最后一个节点指向头部
        head = slow.next; //头节点移到慢指针的下一个节点
        slow.next = null;
        return head;
    }

    //快慢指针：error, 处理 k > 链表长度的逻辑有问题
//    public ListNode rotateRight(ListNode head, int k) {
//        ListNode fast = head, slow = head;
//        while (k-- > 0 && fast.next != null) {
//            fast = fast.next;
//        }
//        if (k == 0 && fast.next == null) {
//            return head;
//        }
//        while (fast.next != null || k > 0) {
//            if (fast.next != null) {
//                fast = fast.next;
//            }
//            if (slow == null) {
//                slow = head;
//            } else {
//                slow = slow.next;
//            }
//            k--;
//        }
//        ListNode res = slow.next;
//        slow.next = null;
//        fast.next = head;
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
T1-20.8.16, >30min
 */