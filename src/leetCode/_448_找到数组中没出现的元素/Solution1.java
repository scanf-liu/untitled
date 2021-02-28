package leetCode._448_找到数组中没出现的元素;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            while (nums[num - 1] != num) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                num = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                ans.add(i + 1);
        }
        return ans;
    }
}