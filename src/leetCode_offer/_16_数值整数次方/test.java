package leetCode_offer._16_数值整数次方;

import java.util.Collection;
import java.util.Collections;

public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2,Integer.MIN_VALUE));
        System.out.println(new Solution2().myPow(2,-100));
        System.out.println(new Solution().myPow(2,-100));
        Collection collections = null;
    }
}
