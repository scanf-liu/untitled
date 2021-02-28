package leetCode_offer._48_最长子字符串;

import java.util.HashMap;

/*本质上与方法一类似，不同点在于左边界 ii 的定义。

哈希表 dicdic 统计： 指针 jj 遍历字符 ss ，哈希表统计字符 s[j]s[j] 最后一次出现的索引 。
更新左指针 ii ： 根据上轮左指针 ii 和 dic[s[j]]dic[s[j]] ，每轮更新左边界 ii ，保证区间 [i + 1, j][i+1,j] 内无重复字符且最大。
i = \max(dic[s[j]], i)
i=max(dic[s[j]],i)

更新结果 resres ： 取上轮 resres 和本轮双指针区间 [i + 1,j][i+1,j] 的宽度（即 j - ij−i ）中的最大值。
res = \max(res, j - i)
res=max(res,j−i)

*/


public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}

