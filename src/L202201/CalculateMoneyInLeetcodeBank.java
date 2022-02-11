package L202201;

public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int start = 1;
        int total = 0;
        for (int i = 0; i < n/7; i++) {
            total += (start + 3) * 7; //total += (start + start + 6) * 7/2
            start++;
        }
        int remain = n % 7;
        for (int i = 0; i < remain; i++) {
            total += start + i;
        }

        return total;
    }
}
