package leetCode.下一个排列;

import java.util.Arrays;


/*实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        int[] a = new int[] {2,3,1};
        Solution.nextPermutation(a);
        for(int i = 0; i < a.length ; i++){
            System.out.println(a[i]);
        }

    }
}

class Solution {
    public static void nextPermutation(int[] nums) {
        int flag = nums.length-1, flag_max = nums.length-1, b = 0;
        if (nums.length == 0) return ;
        for(int i = nums.length - 2; i > -1; i--){
            if (nums[i] > nums[flag_max]){
                flag_max = i;
                b++;
            }
            if (nums[i] < nums[flag_max]){
                flag = i;
                break;
            }
        }

        if (b == nums.length-1){
            Arrays.sort(nums);
            return;
        }else{


            for (int i = nums.length - 1 ; i > flag ; i--){
                if (nums[i] > nums[flag] && nums[i] < nums[flag_max]){
                    flag_max = i;
                }
            }
            b = nums[flag_max];
            nums[flag_max] = nums[flag];
            nums[flag] = b;

            for (int i = flag + 1 ; i < nums.length ; i++){
                for (int j = i + 1; j < nums.length ; j++){
                    if (nums[i] > nums [j]){
                        b = nums[i];
                        nums[i] = nums[j];
                        nums[j] = b;
                    }
                }
            }
        }
        return;

    }
}