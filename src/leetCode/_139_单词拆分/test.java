package leetCode._139_单词拆分;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

用hashmap查

*/


public class test {
    public static void main(String[] args) {
        String a = "abcdbgdbg";
        List<String> aa = new ArrayList<>();
        aa.add("abc");
        aa.add("dbg");
        System.out.println(Solution.wordBreak(a,aa));
    }
}

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        boolean[] dp = new boolean[s.length()+1];
        for(String ss : wordDict){
            map.put(ss,true);
        }
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                dp[i] = dp[j] && check(s.substring(j,i),map);
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }


    public static boolean check(String s, Map<String, Boolean> map){
        return map.getOrDefault(s, false);
    }
}
