package leetCode_other._119_杨辉三角2;

import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        Integer[] ans1 = new Integer[rowIndex];
        Integer[] ans2 = new Integer[rowIndex];
        ans1[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            if ((i & 1) == 1) {
                ans2[0] = 1;
                for (int j = 1; j < i - 1; j++) {
                    ans2[j] = ans1[j - 1] + ans1[j];
                }
                ans2[i - 1] = 1;
            } else {
                ans1[0] = 1;
                for (int j = 1; j < i - 1; j++) {
                    ans1[j] = ans2[j - 1] + ans2[j];
                }
                ans1[i - 1] = 1;
            }
        }

        if ((rowIndex & 1) == 0) {
            return Arrays.asList(ans1);
        } else return Arrays.asList(ans2);

    }
}