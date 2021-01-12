package leetCode.三数字合;

/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

注意双指针的使用


*/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class teat {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,-2,-3,-10,0,5,3};
        List<List<Integer>> lists = Solution.threeSum(nums);
        for (int i=0;i<lists.size();i++){
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }

    }
}
class Solution {
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0 ; i<nums.length-2; i++){
            int target = -nums[i];
            int l = i+1, r = nums.length-1;
            if (nums[i]>0) break;
            if (i==0||nums[i]!=nums[i-1]){
                while(l<r){
                    if (nums[l]+nums[r] == target){
                        a.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if (nums[l]+nums[r] < target) l++;
                    else r--;


                }
            }
        }
        return a ;
    }
}


