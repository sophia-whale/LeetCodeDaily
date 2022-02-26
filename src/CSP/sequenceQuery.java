package CSP;

import java.util.Scanner;

public class sequenceQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int index = 0;
        int sum = 0;
        int last = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int cur = sc.nextInt();
            index++;
            sum += (cur - last) * index;
            last = cur;
        }
        index++;
        sum += (x - last) * index;
        System.out.println(sum);
    }
}
