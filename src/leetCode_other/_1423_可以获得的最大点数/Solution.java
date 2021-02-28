package leetCode_other._1423_可以获得的最大点数;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int minMidSum = 0;
        for (int i = 0; i < cardPoints.length - k; i++) minMidSum += cardPoints[i];
        int sum = minMidSum;
        int temp = minMidSum;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            temp = temp + cardPoints[i] - cardPoints[i - cardPoints.length + k];
            if (temp < minMidSum) minMidSum = temp;
            sum += cardPoints[i];
        }
        return sum - minMidSum;
    }
}