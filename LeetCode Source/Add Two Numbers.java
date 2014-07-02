/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

//error!!!
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int k=0;
        
        while(l1!=null&&l2!=null){
            result.val=(l1.val+l2.val+k)%10;
            if((l1.val+l2.val)>9)
                k=1;
            else
                k=0;
            result=result.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            result.val=l1.val+k;
            if((l1.val+k)>9){
                k=1;
            }else{
                k=0;
            }
            result=result.next;
            l1=l1.next;
        }
        while(l2!=null){
            result.val=l2.val+k;
            if((l2.val+k)>9){
                k=1;
            }else{
                k=0;
            }
            result=result.next;
            l2=l2.next;
        }
        return result;
    }
}

//right
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(0);
        ListNode l3=newHead;
        int carry=0;
        while(l1!=null||l2!=null){
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            l3.next=new ListNode(carry%10);
            l3=l3.next;
            carry/=10;
        }
        if(carry==1){          //注意判断最后一位是否有进位
            l3.next=new ListNode(1);
        }
        return newHead.next;
    }
}