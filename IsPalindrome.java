package leetcode;

/*
9. 回文数
* 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

* */

/**
 * 思路：
 * 1。反转一半，判断反转的一半和剩下的一半是否相等
 * 2。转换成字符串进行反转，判断反转前后的字符串是否相等
 */


public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
    }
    // 1.第一种：但是跑出来的结果也很占用额外的空间
    public static boolean isPalindrome1(int x){
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int reverseNum = 0;
        while (x>reverseNum){
            reverseNum = reverseNum*10 + x%10;
            x /= 10;
        }
        return x==reverseNum || x==reverseNum/10;
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if(str.startsWith("-"))
            return false;
        String str2 = swap(str,0,str.length()-1);
        if(str.equals(str2))
            return true;
        return false;
    }

    public static String swap(String str, int i, int j){
        char[] chs = str.toCharArray();
        while(i<j){
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
        return new String(chs);
    }
}
