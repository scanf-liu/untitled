package leetCode_other._896_单调数列;
/*896. 单调数列
如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。*/
public class Solution {
    public boolean isMonotonic(int[] A) {
        int flag = 0;
        if(A.length == 1) return true;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i-1]) continue;

            if(A[i] > A[i-1]){
                if(flag == 0) flag = 1;
                else if(flag == -1) return false;
            }else{
                if(flag == 0) flag = -1;
                else if(flag == 1) return false;
            }
        }

        return true;
    }
}