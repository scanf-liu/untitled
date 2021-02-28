package leetCode._78_全子集;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8};
        System.out.println(Solution.subsets(a).toString());
    }
}


class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        ans.add(new ArrayList<>());
        list.add(new ArrayList<>());
        List<Integer> flag = new ArrayList<>();
        flag.add(0);

        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            for (int j = 0; j < list.size(); j++) {
                List<Integer> now = new ArrayList<>(list.remove(0));
                int now_flag = flag.get(0).intValue();
                flag.remove(0);
                for (int k = now_flag; k < nums.length; k++) {
                    now.add(nums[k]);
                    list.add(new ArrayList(now));
                    ans.add(new ArrayList(now));
                    flag.add(k + 1);
                    now.remove(now.size() - 1);
                }

            }
        }

        return ans;
    }
}
