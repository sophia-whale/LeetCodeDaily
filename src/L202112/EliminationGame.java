package L202112;

/*You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order.
Apply the following algorithm on arr:
1.Starting from left to right,
remove the first number and every other number afterward until you reach the end of the list.
2.Repeat the previous step again, but this time from right to left,
remove the rightmost number and every other number from the remaining numbers.
3.Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
Given the integer n, return the last number that remains in arr.*/

public class EliminationGame {
    public static void main(String[] args) {
        System.out.println(lastRemaining(10));
    }

    public static int lastRemaining(int n) {
        // n为1时 返回1
        // n为其他数时 返回值永远为偶数
        // 设置趟数 奇数次为从左向右 偶数次为从右向左
        // 设置已删除的数字个数 删除的步长与趟数相同
        // 记录当前的头和尾
        // 综上 亦可用递归解决 需找寻递归出口
        int step = 1;
        int times = 0;
        int start = 1;
        int end = n;
        if (n == 1) return 1;
        while (n != 1) {
            if (n % 2 == 0 && times % 2 == 0) {
                start = start + step;
            } else if (n % 2 == 0 && times % 2 == 1) {
                end = end - step;
            } else {
                start = start + step;
                end = end - step;
            }
            times++;
            step = step * 2;
            n = n/2;
        }
        //if (end - start == step/2 && times % 2 == 0)  return start;
        //if (end - start == step/2 && times % 2 == 1)  return end;
        return start;
    }
}
