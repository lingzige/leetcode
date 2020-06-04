package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] answer = new int[nums.length];

        // 对于i左边的元素，L[i]为i左边所有元素的乘积
        L[0] = 1;
        for(int i=1;i<nums.length;i++){
            L[i] = nums[i-1]*L[i-1];
        }

        // R[i]为i右边所有元素的乘积
        R[nums.length-1] = 1;
        for(int i=nums.length-2;i>=0;i--){
            R[i] = nums[i+1]*R[i+1];
        }

        for(int i=0;i<nums.length;i++){
            answer[i] = L[i]*R[i];
        }
        return answer;

    }
}
