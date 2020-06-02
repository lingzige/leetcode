package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

        /**
         * 1。 超出内存限制
         * if(l1==null && l2==null)
         *             return null;
         *         if(l1==null)
         *             return l2;
         *         if(l2==null)
         *             return l1;
         *         ListNode list = new ListNode(-1);
         *         ListNode pre = list;
         *         int flag = 0;
         *         while(l1!=null && l2!=null){
         *             int value = l1.val+l2.val+flag;
         *             flag = 0;
         *             int realNum = value%10;
         *             int ret = value/10;
         *             if(ret==0){
         *                 pre.next = new ListNode(realNum);
         *             }else{
         *                 // ret!=0,realNum=0说明value是10的整倍数
         *                 if(realNum==0){
         *                     pre.next = new ListNode(0);
         *                     flag += ret;
         *                 }else {
         *                     // 不是10的整倍数
         *                     pre.next = new ListNode(realNum);
         *                     flag += ret;
         *                 }
         *             }
         *             l1 = l1.next;
         *             l2 = l2.next;
         *             pre = pre.next;
         *         }
         *         if(flag!=0)
         *             pre.next = new ListNode(flag);
         *         if(l1 != null){
         *             while(l1!=null){
         *                 pre.next = new ListNode(l1.val);
         *                 l1 = list.next;
         *                 pre = pre.next;
         *             }
         *         }
         *         if(l2 != null){
         *             while(l2!=null){
         *                 pre.next = new ListNode(l2.val);
         *                 l2 = list.next;
         *                 pre = pre.next;
         *             }
         *         }
         *         return list.next;
         */

    }
}
