package leetCode_other._303_区域和检索;

public class NumArray {
    private int[] nums;
    private int[] helper;
    private int end;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.helper = new int[nums.length+1];
        end = 0;
    }

    public int sumRange(int i, int j) {
        if(end > j) return helper[j+1] - helper[i];

        for(int k = end; k <= j+1 ; k++){
            if(k==0) continue;
            helper[k] = helper[k-1] + nums[k-1];
        }
        end = j+1;
        return helper[j+1] - helper[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */