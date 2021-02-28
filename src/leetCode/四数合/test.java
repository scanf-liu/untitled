package leetCode.四数合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = Solution.fourSum(a, target);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }

    }


}

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int a1 = -100, b1 = -100, c1 = -100, d1 = -100;
        for (int a = 0; a < nums.length - 3; a++) {
            //if nums[]；
            if (a != 0) {
                if (a1 == nums[a]) {
                    continue;
                }
            }
            for (int b = 1; (a + b) < nums.length - 2; b++) {
                if (b != 1) {
                    if (b1 == nums[a + b]) {
                        continue;
                    }
                }
                for (int c = 1; a + b + c < nums.length - 1; c++) {
                    if (c != 1) {
                        if (c1 == nums[a + b + c]) {
                            continue;
                        }
                    }

                    for (int d = 1; a + b + c + d < nums.length; d++) {
                        if (d != 1) {
                            if (d1 == nums[a + b + c + d]) {
                                continue;
                            }
                        }

                        if (nums[a] + nums[a + b] + nums[a + b + c] + nums[a + b + c + d] == target) {
                            lists.add(new ArrayList<>(Arrays.asList(nums[a], nums[a + b], nums[a + b + c], nums[a + b + c + d])));
                        }
                        a1 = nums[a];
                        b1 = nums[a + b];
                        c1 = nums[a + b + c];
                        d1 = nums[a + b + c + d];
                    }
                }
            }
        }
        return lists;
    }
}