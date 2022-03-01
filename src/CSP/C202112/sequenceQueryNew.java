package CSP.C202112;

import java.util.Scanner;

public class sequenceQueryNew {
    public static void main(String[] args) {
        // 超时 仅通过70%
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int r = x/(n + 1);
        int index = 0;
        int g = 0;
        int error = 0;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        nums[n] = x;

        for (int i = 0; i < nums[0]; i++) {
            error += Math.abs(g - index);
            if ((i + 1) % r == 0) g++;
        }
        index++;
        // System.out.println("g " + g + " error " + error + " index " + index);

        for (int i = 1; i < n + 1; i++) {
            for (int j = nums[i - 1]; j < nums[i]; j++) {
                error += Math.abs(g - index);
                if ((j + 1) % r == 0) g++;
                // System.out.println("g " + g + " error " + error);
            }
            index++;
            // System.out.println(index);
        }
        System.out.println(error);
    }
}
