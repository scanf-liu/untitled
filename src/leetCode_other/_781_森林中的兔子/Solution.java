package leetCode_other._781_森林中的兔子;

import java.util.HashMap;

public class Solution {
    public int numRabbits(int[] answers) {
        int cnt[] = new int[1005];
        int ans = 0;

        for (int i = 0; i < answers.length; i++) {
            if (cnt[answers[i]] == 0) {
                //没有相同个数的颜色类型可以匹配
                ans += answers[i] + 1;
                cnt[answers[i]] = answers[i];
            }
            else {
                cnt[answers[i]]--;
            }
        }
        return ans;
    }

    public int numRabbits1(int[] answers) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int ans = 0;
        for(int i: answers){
            if(i == 0) ans++;
            else{
                int helper = set.getOrDefault(i,0);
                if(helper == 0){
                    set.put(i, i);
                    ans += (i+1);
                }else{
                    set.put(i, helper-1);
                }
            }
        }

        return ans;
    }


}