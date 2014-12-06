/*
Sort a linked list using insertion sort.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode list=new ListNode(-1);  //引入一个哨兵
        ListNode pre=list;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp=cur.next;  //先用临时的temp将cur的下一节点存起来
            pre=list;                //将已排的有序链表list赋给pre
            while(pre.next!=null&&pre.next.val<cur.val){   //比要比较的值小的，指针指向下一节点
                pre=pre.next;
            }                                   
            cur.next=pre.next;        //将要比较的节点和有序的后半部分连接起来
            pre.next=cur;             //将前半部分和后半部分连接起来
            cur=temp;                 //相当于指针移到下一节点
        }
        return list.next;
    }
}