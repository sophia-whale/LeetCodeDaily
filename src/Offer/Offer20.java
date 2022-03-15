package Offer;

public class Offer20 {
    public static void main(String[] args) {
        System.out.println(isNumber1(".1"));
        System.out.println(isNumber1("e+1e12"));
    }

    public boolean isNumber(String s) {
        // 判断是否全为+-
        boolean num = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (s.substring(i).contains(".")) return false;
            }
            if (s.charAt(i) == '.') {
                if (i == 0 && (s.length() == 1 || s.charAt(i + 1) - '0' > 9 || s.charAt(i + 1) - '0' < 0)) return false;
                else if (i == s.length() - 1  && (s.charAt(i - 1) - '0' > 9 || s.charAt(i - 1) - '0' < 0)) return false;
            }
            if (s.charAt(i) - '0' >= 0 || s.charAt(i) - '0' <= 9) num = true;
        }
        return num;
    }

    public static boolean isNumber1(String s) {
        boolean num = false;
        if (s.lastIndexOf('e') - s.indexOf('e') > 0 || s.lastIndexOf('.') - s.indexOf('.') > 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (s.substring(i).contains(".") || s.length() == 1 || i == s.length() - 1) return false;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    if (i + 2 > s.length() || s.charAt(i + 2) - '0' > 9 || s.charAt(i + 2) - '0' < 0) return false;
                } else if (s.charAt(i + 1) - '0' > 9 || s.charAt(i + 1) - '0' < 0) return false;
            } else if (s.charAt(i) == '.') {
                if (i == 0 && (s.length() == 1 || s.charAt(i + 1) - '0' > 9 || s.charAt(i + 1) - '0' < 0)) return false;
                else if (i == s.length() - 1  && (s.charAt(i - 1) - '0' > 9 || s.charAt(i - 1) - '0' < 0)) return false;
            } else if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                num = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else return false;
        }
        return num;
    }
}
