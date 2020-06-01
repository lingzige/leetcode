package leetcode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode res = new ListNode(-1);
        ListNode ret = res;
        while(l1 != null && l2 != null){
            if(l1.val>=l2.val){
                ret.next = l2;
                l2=l2.next;
                ret = ret.next;
            }else {
                ret.next = l1;
                l1 = l1.next;
                ret = ret.next;
            }
        }
        if(l1 != null)
            ret.next = l1;
        if(l2 != null)
            ret.next = l2;
        return res.next;
    }
}
