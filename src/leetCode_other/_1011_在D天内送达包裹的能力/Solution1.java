package leetCode_other._1011_在D天内送达包裹的能力;

public class Solution1 {
    public int shipWithinDays(int[] weights, int D) {
        int[][] helper = new int[3][weights.length];
        helper[0][0] = weights[0];
        helper[1][0] = weights[0];
        for(int i = 1 ; i < weights.length ; i++){
            helper[0][i] = weights[i] + helper[0][i-1];
            helper[1][i] = helper[0][i];
        }
        for(int i = 1 ; i < D ; i++){
            for(int j = i ; j < weights.length ; j++){
                int ans = Integer.MAX_VALUE;
                for(int k = i-1 ; k < j ; k++){
                    ans = Math.min(ans, Math.max(helper[(i-1)%2+1][k], helper[0][j]-helper[0][k]));
                }
                helper[i%2+1][j] = ans;
            }
            // for(int[] y : helper){
            //     System.out.println(Arrays.toString(y));
            // }
        }



        return helper[(D-1)%2+1][weights.length-1];

    }
}