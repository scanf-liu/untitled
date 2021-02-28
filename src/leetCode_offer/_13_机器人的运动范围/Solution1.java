package leetCode_offer._13_机器人的运动范围;

import java.util.LinkedList;

public class Solution1 {
    public int movingCount(int m, int n, int k) {
        boolean[][] helper = new boolean[m][n];
        int ans = 0;
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0, 0});
        int[] target = new int[2];
        while (list.size() != 0) {
            target = list.removeFirst();
            if (target[0] >= m || target[0] < 0 || target[1] >= n || target[1] < 0 || judge(target[0], target[1], k))
                continue;
            if (helper[target[0]][target[1]]) continue;
            helper[target[0]][target[1]] = true;
            //System.out.println(target[0]+" "+target[1]);
            ans++;
            //list.add(new int[]{target[0]-1, target[1]});
            list.add(new int[]{target[0] + 1, target[1]});
            list.add(new int[]{target[0], target[1] + 1});
            //list.add(new int[]{target[0], target[1]-1});
        }
        return ans;
    }

    private boolean judge(int m, int n, int k) {
        return ((m / 100 + m / 10 % 10 + m % 10 + n / 100 + n / 10 % 10 + n % 10) > k);
    }
}