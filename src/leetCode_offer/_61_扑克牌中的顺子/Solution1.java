package leetCode_offer._61_扑克牌中的顺子;

public class Solution1 {
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[13];
        for (int num : nums) {
            if (num != 0) {
                if (arr[num - 1] == 1)
                    return false;
                else arr[num - 1] = 1;
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
        }
        return max - min + 1 <= 5;
    }
}
