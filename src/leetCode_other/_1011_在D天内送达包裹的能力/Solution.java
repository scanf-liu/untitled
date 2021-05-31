package leetCode_other._1011_在D天内送达包裹的能力;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // 载重范围，最小应该是货物中最大重量（否则就没办法装船了）
        int left = 0;
        for (int weight : weights) {
            if (weight > left) {
                left = weight;
            }
        }
        // 最大应该是假设每个货物都为最大，平均每天能带多少
        // 注：当D > weights.length 时, right < left 即 此时会直接返回 left。而背后的逻辑是，当天数大于货物数量，那么只要每天至少搬一个货物上船即可，此时可以达到区间的最小，即货物的最大重量
        int right =  weights.length / D * left + left;
        // 取值区间使用左右闭合
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (canFinish(weights, D, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] weights, int D, int cap) {
        int day = 1, cur = cap;
        for (int weight : weights) {
            if (weight > cur) {
                day++;
                cur = cap;
            }
            cur -= weight;
        }
        return day <= D;
    }


}