package leetCode.括号匹配;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        String a = "()()(){}";
        System.out.println(Solution.isValid(a));
    }
}

class Solution {
    public static boolean isValid(String s) {

        int size = s.length();
        //if (size==0) return true;

        //if (size%2 == 1) return false;

        char[] a = new char[size];
        int num = 0;
        for (int i = 0 ; i < size; i++){
            if (s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{'){
                a[num++] = s.charAt(i);
            }else if (num == 0) return false;
            else if(s.charAt(i) == ')'){
                if (a[num-1] == '('){
                    num --;
                }else return false;
            }else if(s.charAt(i) == ']'){
                if (a[num-1] == '['){
                    num --;
                }else return false ;
            }else if(s.charAt(i) == '}'){
                if (a[num-1] == '{'){
                    num --;
                }else return false ;
            }
        }
        if (num == 0) return true;
        else return false;
    }
}