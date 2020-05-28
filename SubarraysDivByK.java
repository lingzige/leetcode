package leetcode;


import java.util.HashMap;
import java.util.Map;

/*
* 974. 和可被 K 整除的子数组
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

示例：

输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


提示：

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
* */
public class SubarraysDivByK {

    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(arr, 5));
    }

    public static int subarraysDivByK(int[] A, int K) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0,1);
//        int preNum = 0;
//        for (int i = 0; i < A.length; i++) {
//            preNum += A[i];
//            int key = (preNum % K + K) % K;
//            if(map.containsKey(key)){
//                map.put(key, map.get(key)+1);
//            }else
//                map.put(key,1);
//        }
//        return map.get(0);
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;


    }
}
