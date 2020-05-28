package leetcode;


import java.util.Collections;

/*
* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

* */
public class Reverse {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        if(str.startsWith("-")){
            String res = swap(str,1,str.length()-1);
            long value = Long.parseLong(res);
            if(value<Integer.MIN_VALUE){
                return 0;
            }
            return (int)value;
        }else {
            str = swap(str, 0, str.length()-1);
            long value = Long.parseLong(str);
            if(value>Integer.MAX_VALUE){
                return 0;
            }
            return (int)value;
        }

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
