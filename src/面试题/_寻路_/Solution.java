package 面试题._寻路_;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int cal(int[][] des,int max ){
        for (int i = 0; i < des.length; i++) {
            for (int j = i+1; j < des.length; j++) {
                for(int k = i+1; k < j; k++){
                    if(des[i][k] == -1 || des[k][j]== -1) continue;
                    if(des[i][j] == -1) des[i][j] = des[i][k]+des[k][j];
                    else des[i][j] = Math.min(des[i][j],des[i][k]+des[k][j]);
                    if(des[i][j] > max) des[i][j] = -1;
                }
            }
        }

        int[] ans = new int[des.length];
        for (int i = 0; i <des.length ; i++) {
            for(int j = i+1; j < des.length; j++){
                if(des[i][j] != -1 && des[i][j] <= max){
                    ans[i]++;
                    ans[j]++;
                }
            }
        }
        int minCity = 0;
        int cityNum = ans[0];
        for (int i = 1; i < des.length; i++) {
            if(ans[i] != 0 && ans[i] <= cityNum){
                cityNum = ans[i];
                minCity = i;
            }
        }
        if(cityNum == 0) return des.length-1;
        else return minCity;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int len = Integer.parseInt(line);
        for (int i = 0; i < len; i++) {
            line = scanner.nextLine();
            String[] helper = line.split(" ");
            int city = Integer.parseInt(helper[0]);
            int roud = Integer.parseInt(helper[1]);
            int max = Integer.parseInt(helper[2]);
            int[][] des = new int[city][city];
            for (int j = 0; j < city; j++) {
                Arrays.fill(des[j],Integer.MAX_VALUE);
            }
            for (int j = 0; j < roud; j++) {
                line = scanner.nextLine();
                helper = line.split(" ");
                des[Integer.parseInt(helper[0])][Integer.parseInt(helper[1])] = Integer.parseInt(helper[2]);
            }
            System.out.println(new Solution().cal(des,max));
        }
    }
}
