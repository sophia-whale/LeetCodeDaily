package L202203;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits1(38));
    }

    public static int addDigits(int num) {
        while (num > 9) {
            String nums = String.valueOf(num);
            int sum = 0;
            for (int i = 0; i < nums.length(); i++) {
                sum += nums.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }

    // 同余取数 证明见图 AddDigits
    public static int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}
