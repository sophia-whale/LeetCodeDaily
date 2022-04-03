package Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Offer49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumberDynamic(15));
    }

    // 只包含质因子 2、3 和 5 的数称作丑数
    public static int nthUglyNumberNo(int n) {
        int cur = 1;
        while (n > 1) {
            cur++;
            if (cur % 7 == 0 || (cur % 2 != 0 && cur % 3 != 0 && cur % 5 != 0 )) continue;
            n--;
        }
        return cur;
    }

    // 动态规划
    /*
     * @Author Whale Feng 
     * @Description //TODO 丑数 = 较小的丑数 * 2/3/5
     * @Date 15:09 2022/4/2
     * @Param [n]
     * @return int
     **/
    public static int nthUglyNumberDynamic(int n) {
        return 0;
    }
}
