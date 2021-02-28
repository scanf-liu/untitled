package leetCode_offer._39_数组中超过一半的数字;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 1, 1, 1, 1};
        System.out.println(new Solution().majorityElement(a));
        System.out.println(new Solution2().majorityElement(a));
        System.out.println(new Solution1().majorityElement(a));
    }
}
