package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "bbbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    // 官方答案：时间复杂度较低
    public static int lengthOfLongestSubstring2(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }

    // 自己写的，暴力法，时间复杂度较高
    public static int lengthOfLongestSubstring(String s) {

        if(s==null)
            return 0;
        if(s.length() == 1)
            return 1;
        String max_substring = "";
        String sum_substring = "";
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length-1;i++){
            sum_substring = String.valueOf(chs[i]);
            for(int j=i+1;j<chs.length;j++){
                if(sum_substring.contains(String.valueOf(chs[j])))
                    break;
                else{
                    sum_substring += String.valueOf(chs[j]);
                }
            }
            if(sum_substring.length()>max_substring.length()){
                max_substring = sum_substring;
            }
        }

        return max_substring.length();
    }
}
