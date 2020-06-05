package leetcode;

import java.util.concurrent.Executor;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        int s = nums[0];
        for(int i=1;i<nums.length;i++){
            s = s^nums[i];
        }
        return s;
    }

}
