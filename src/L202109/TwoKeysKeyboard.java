package L202109;

/*
* 2021.09.19
There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 */

/*如果我们将「1 次 Copy All + x 次 Paste」看做一次“动作”的话。

那么一次“动作”所产生的效果就是将原来的字符串变为原来的 x + 1 倍。最终的最小操作次数方案可以等价以下操作流程：

起始对长度为 1 的记事本字符进行 1 次 Copy All + k_1 - 1 Paste 操作（消耗次数为 k_1得到长度为 k_1的记事本长度）；
对长度为为 k_1 的记事本字符进行 1 次 Copy All + k_2 - 1 次 Paste 操作（消耗次数为 k_1 + k_2得到长度为 k_1 * k_2的记事本长度）
...
最终经过 k 次“动作”之后，得到长度为 n 的记事本长度，即有：n = k_1 * k_2 * ... * k_x

问题转化为：如何对 n 进行拆分，可以使得 k_1 + k_2 + ... + k_x最小。

对于任意一个 k_i（合数）而言，根据定理 a * b >= a + b可知进一步的拆分必然不会导致结果变差。

因此，我们只需要使用「试除法」对 n 执行分解质因数操作，累加所有的操作次数，即可得到答案。*/

public class TwoKeysKeyboard {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(minSteps(n));
    }

    public static int minSteps(int n) {
        if (n == 1)return 0;
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }
        if (n != 1) ans += n;
        return ans;
    }
}
