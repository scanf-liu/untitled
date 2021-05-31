package leetCode_other._87_扰乱字符串;

import java.util.HashMap;
import java.util.Map;
/*87. 扰乱字符串
使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
如果字符串的长度为 1 ，算法停止
如果字符串的长度 > 1 ，执行下述步骤：
在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。



示例 1：

输入：s1 = "great", s2 = "rgeat"
输出：true
解释：s1 上可能发生的一种情形是：
"great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
"gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
"gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
"g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
"r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
"r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
算法终止，结果字符串和 s2 相同，都是 "rgeat"
这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
示例 2：

输入：s1 = "abcde", s2 = "caebd"
输出：false
示例 3：

输入：s1 = "a", s2 = "a"
输出：true


提示：

s1.length == s2.length
1 <= s1.length <= 30
s1 和 s2 由小写英文字母组成*/
public class Solution {
    Map<String, Map<String, Boolean>> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        // 判断两个字符串是否有着相同的字符（不论顺序）
        if (hashCode(s1) != hashCode(s2)) return false;
        int len = s1.length();
        // 长度小于等于3的时候，都可以进行扰乱得到
        if (len <= 3) return true;

        // 判断是否已经遍历过s1，然后判断是否有对应的s2
        if (map.containsKey(s1) && map.get(s1).containsKey(s2)) {
            return map.get(s1).get(s2);
        }

        for (int i = 1; i < len; i++) {
            // 进行切割得到子字符串
            String s1L = s1.substring(0, i);
            String s1R = s1.substring(i);
            // 进行一个递归
            if (isScramble(s1L, s2.substring(0, i)) && isScramble(s1R, s2.substring(i))
                    || isScramble(s1L, s2.substring(len - i)) && isScramble(s1R, s2.substring(0, len - i))) {
                // 对当前s1与s2进行一个存储
                map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, true);
                return true;
            }
        }
        // 对当前s1与s2进行一个存储
        map.computeIfAbsent(s1, z -> new HashMap<>()).put(s2, false);
        return false;
    }

    // 自定义hashcode
    private int hashCode(String s) {
        int hash = 0;
        for (char c: s.toCharArray()) {
            hash += 1 << c - 'a';
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isScramble("great", "rgeat"));
        System.out.println(new Solution().isScramble("sdafdas", "fsdadas"));
    }
}
