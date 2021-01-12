package leetCode.中位数;
/**/


public class test {
    public static void main(String[] args) {
        int[] a1 = new int[] {1,2};
        int[] b1 = new int[] {2,4,6};
        System.out.println(Solution.findMedianSortedArrays(a1,b1));
        
    }
}


class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num3_length = nums1.length+nums2.length;
        int i1 = 0, i2 = 0;
        float answer = 0;
        if (num3_length%2 == 0 ){
            for (int i = 0; i < num3_length/2 + 1; i++){
                if (i1 < nums1.length && i2 == nums2.length){
                    if (i == num3_length/2-1){
                        answer = nums1[i1];
                    }else if (i == num3_length/2){
                        answer = (answer + nums1[i1])/2;
                    }
                    i1++;
                }else if (i1 == nums1.length && i2 < nums2.length){
                    if (i == num3_length/2-1){
                        answer = nums2[i2];
                    }else if (i == num3_length/2){
                        answer = (answer + nums2[i2])/2;
                    }
                    i2++;
                }else if (nums1[i1] < nums2[i2]){
                    if (i == num3_length/2-1){
                        answer = nums1[i1];
                    }else if (i == num3_length/2){
                        answer = (answer + nums1[i1])/2;
                    }
                    i1++;
                }else{
                    if (i == num3_length/2-1){
                        answer = nums2[i2];
                    }else if (i == num3_length/2){
                        answer = (answer + nums2[i2])/2;
                    }
                    i2++;
                }
            }
        }else{
            for (int i = 0; i < num3_length/2 + 1; i++){
                if (i1 < nums1.length && i2 == nums2.length){
                    if (i == num3_length/2){
                        answer = nums1[i1];
                    }
                    i1++;
                }else if (i1 == nums1.length && i2 < nums2.length){
                    if (i == num3_length/2){
                        answer = nums2[i2];
                    }
                    i2++;
                }else if (nums1[i1] < nums2[i2]){
                    if (i == num3_length/2){
                        answer = nums1[i1];
                    }
                    i1++;
                }else{
                    if (i == num3_length/2){
                        answer = nums2[i2];
                    }
                    i2++;
                }
            }
        }
        return answer;

    }
}