package leetCode_other._839_相似字符串组;

public class Solution {
    public int numSimilarGroups(String[] strs) {

        int[] helper = new int[strs.length];
        int index = 0;
        int sum = 0;
        for (int i = 0; i < strs.length; i++) {
            if (helper[i] == 0) {
                helper[i] = ++index;
                sum++;
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (helper[j] == helper[i]) continue;
                if (judge(strs[i], strs[j])) {
                    if (helper[j] == 0) helper[j] = helper[i];
                    if (helper[j] != 0 && helper[j] != helper[i]) {
                        int f = helper[i];
                        for (int k = 0; k < strs.length; k++) {
                            if (helper[k] == f) helper[k] = helper[j];
                        }
                        //发生合并事件，sum--
                        sum--;
                    }
                }
                //System.out.println(strs[i]+"\t"+strs[j]+"\t"+judge(strs[i],strs[j]));
            }
        }
        //System.out.println(Arrays.toString(helper));
        return sum;

    }

    //抄的官方题解，因为strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。所以不需要复杂的判断。
    private boolean judge(String a, String b) {
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
