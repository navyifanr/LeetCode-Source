/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fakeHead=new ListNode(-1);  //前驱指针
        fakeHead.next=head;
        ListNode pre=fakeHead;
        ListNode cur=head;
        while(cur!=null){
            //若头部重复
            while(cur.next!=null&&pre.next.val==cur.next.val){
                cur=cur.next;
            }
            
            if(pre.next==cur){
                pre=pre.next;  //头部无重复,移动pre
            }else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return fakeHead.next;
    }
}


//笨方法，超时
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=cur.next.val){   //判断头部是否重复
                ListNode pre=cur.next;
                while(pre!=null&&pre.next!=null&&pre.val==pre.next.val){
                    pre.next=pre.next.next;
                }
                if(pre.next!=null){
                    cur.next=pre.next;   //当while从pre.next==null退出时，保留pre当前点
                }
            }else{
                ListNode temp=cur.next;
                while(temp!=null&&cur.val==temp.val){
                    temp=temp.next;
                }
                head=temp;
                cur=head;
            }
        }
        return head;
    }
}