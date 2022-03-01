package EasyProblem;

public class L0069 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
        System.out.println(sqrtE(2147395600));
    }

    public static int mySqrt(int x) {
        long n = 0;
        while (n <= x/2) {
            if (n * n <= x && (n+1) * (n+1) > x) {
                break;
            }
            n++;
        }
        return (int)n;
    }

    public static int sqrtE(int x) {
        //将根号x取ln得到e的1/2lnx
        //将x为0的情况特殊处理
        if (x == 0) return 0;
        int res = (int) Math.exp(0.5 * Math.log(x));
        if ((res+1) * (res+1) <= x) res++;
        return res;
    }


}
