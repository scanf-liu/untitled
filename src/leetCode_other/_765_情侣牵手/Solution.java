package leetCode_other._765_情侣牵手;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            if ((row[i] >> 1) == (row[i + 1] >> 1)) continue;
            for (int j = i; j < row.length; j++) {
                if ((i != j) && (row[i] >> 1) == (row[j] >> 1)) {
                    int temp = row[i + 1];
                    row[i + 1] = row[j];
                    row[j] = temp;
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}