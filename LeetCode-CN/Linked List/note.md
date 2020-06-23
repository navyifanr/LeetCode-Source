## 链表解题思路

- 链表翻转问题：注意区分创建节点的两种方式：new新节点和直接通过老节点赋值；**(直接赋值后续新节点修改会影响原节点)**

注意节点交换的方法，如[24]两两交换链表中节点
```$xslt
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode preNode = fakeHead;
        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //交换节点
            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            preNode = firstNode;
            head = firstNode.next;
        }
        return fakeHead.next;
    }
```
