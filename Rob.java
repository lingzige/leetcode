package leetcode;

/*
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
* 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

* */

/*
* 思路：动态规划+数组
* 1. 当只有一个房屋时，直接可以偷，返回nums[0]
* 2. 当有两个房屋时，只能偷两个中金额大的那个房屋,返回math.max(nums[0],nums[1])
* 3. 当房屋超过2个时：
*   -1. 假设偷第k个房屋，那么就不能偷第k-1个，所以偷盗的金额是前k-2个房屋的最高总金额+第k个房屋的金额：dp[k-2]+nums[k]
*   -2。假设不偷第k个房屋，那么偷盗的最高总金额为前k-1个房屋的最高总金额:dp[k-1]
* 4. 边界条件：
*   dp[0]=nums[0]
*   dp[1]=math.max(nums[0],nums[1])
* */

public class Rob {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
//        int i=2;
////        while(i<len)
        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];

    }
}
