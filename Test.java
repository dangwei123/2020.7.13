在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        ListNode pre=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        ListNode next=pre.next;
        pre.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(next);
        return merge(left,right);
    } 

    private ListNode merge(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.val<head2.val){
            head1.next=merge(head1.next,head2);
            return head1;
        }else{
            head2.next=merge(head1,head2.next);
            return head2;
        }
    }

}