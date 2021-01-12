package leetCode._49_字母异位词分组;


/*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


import java.util.*;

public class test {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = Solution.groupAnagrams(strs);
        for (int i = 0; i < list.size(); i++ ){
            System.out.println(list.get(i));
        }

    }
}


class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        //map中key存储的是字符串中字母排序后新的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //取出字符串，然后把它转化为字符数组
            char[] c = strs[i].toCharArray();
            //对字符数组进行排序
            Arrays.sort(c);
            //排序之后再把它转化为一个字符串
            String keyStr = String.valueOf(c);
            //判断map中有没有这个字符串，如果没有这个字符串，
            //说明还没有出现和这个字符串一样的字母异位词，
            //要新建一个list，把它存放到map中
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            //把字符串存放到对应的list中
            map.get(keyStr).add(strs[i]);
        }
        //最后返回
        return new ArrayList<>(map.values());
    }
}