package Algorithm.DoublePointer;

public class L0633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(0));
    }

    public static boolean judgeSquareSum(int c) {
        if (c == 0)return true;
        for (int i = 0; i < Math.sqrt(c); i++) {
            if (Math.sqrt(c - i * i) % 1 == 0)return true;
        }
        return false;
    }
}
