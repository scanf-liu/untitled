package leetCode._221_最大正方形;

public class test {
    public static void main(String[] args) {
        char[][] a = new char[][]{{
                '0', '0', '0', '0', '1'}, {'0', '0', '0', '0', '1'}, {'0', '0', '0', '0', '1'}, {'0', '0', '0', '0', '1'}, {'0', '0', '0', '0', '1'}};
        System.out.println(Solution.maximalSquare(a));
        System.out.println(Solution.maximalSquare1(a));
    }
}
