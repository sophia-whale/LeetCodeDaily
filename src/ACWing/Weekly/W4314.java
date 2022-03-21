package ACWing.Weekly;

import java.util.Scanner;

public class W4314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        // 按位异或 ^
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                for (int k = j; k < n + 1; k++) {
                    int y = i^j^k;
                    if (y == 0 && (i + j) > k && (i + k) > j && (j + k) > i) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
