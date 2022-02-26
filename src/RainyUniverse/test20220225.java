package RainyUniverse;

public class test20220225 {
    public static void main(String[] args){
        String str1 = "1+1i";
        String str2 = "1+1i";
        Solution solution = new Solution();
        String res = solution.complexNumberMultiply(str1, str2);
        System.out.println(res);
    }
}


class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split("\\+");
        String[] arr2 = num2.split("\\+");
        int a1 = Integer.parseInt(arr1[0]);
        int a2 = Integer.parseInt(arr2[0]);
        int b1 = Integer.parseInt(arr1[1].split("i")[0]);
        int b2 = Integer.parseInt(arr2[1].split("i")[0]);
        int real = a1*a2-b1*b2;
        int ima = a2*b1+a1*b2;
        return real+"+"+ima+"i";
    }
}