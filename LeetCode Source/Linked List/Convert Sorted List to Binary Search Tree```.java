/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
        ListNode cur=head;
        int count=0;
        while(cur!=null){
        	cur=cur.next;
        	count++;
        }
        List<ListNode> list=new ArrayList<ListNode>();
        list.add(head);
        return helper(list,0,count-1);
    }
    private TreeNode helper(List<ListNode> list,int l,int r){
    	if(l>r){
    		return null;
    	}
    	int m=(l+r)/2;
    	TreeNode left=helper(list,l,m-1);
    	TreeNode root=new TreeNode(list.get(0).val);
    	root.left=left;
    	list.set(0,list.get(0).next);
    	root.right=helper(list,m+1,r);
    	return root;
    }
}