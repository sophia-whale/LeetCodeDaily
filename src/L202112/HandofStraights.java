package L202112;
/*
* 2021.12.30
* Alice has some number of cards and
* she wants to rearrange the cards into groups so that each group is of size groupSize,
* and consists of groupSize consecutive cards.
* Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
* return true if she can rearrange the cards, or false otherwise.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HandofStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,5,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    // 首先，hand的张数可整除groupSize
    // 将hand数组从小到大排列
    // for循环依次按顺序去掉groupSize的连续数字
    // 若最后数组中有剩余数字 或者 中途发现不能连续形成长度为groupSize的排列组合 即false
    // 否则 true
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int length = hand.length;
        if (length % groupSize != 0) return false;
        quickSort(hand, 0, hand.length - 1);
        ArrayList<Integer> cur = (ArrayList<Integer>) Arrays.stream(hand).boxed().collect(Collectors.toList());;

        for (int i = 0; i < length; i++) {
            int[] deleteIndex = new int[groupSize];
            int num = 0;
            int j = 0;
            while (num < groupSize - 1 && j < cur.size() - 1) {
                if (cur.get(j) + 1 == cur.get(j + 1)) {
                    deleteIndex[num] = j;
                    num++;
                }
                j++;
            }
            if (num != groupSize - 1) return false;
            deleteIndex[groupSize = 1] = j;
            for (int k = 0; k < groupSize; k++) {
                cur.remove(deleteIndex[k]);
            }
        }
        return cur.isEmpty();
    }

    public static void quickSort(int[] hand, int start, int end) {
        if (start >= end) return;
        int base = hand[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && hand[high] >= base) {
                high--;
            }
            if (hand[high] < base) {
                hand[low] = hand[high];
                low++;
            }
            while (low < high && hand[low] <= base) {
                low++;
            }
            if (hand[low] > base) {
                hand[high] = hand[low];
                high--;
            }
        }
        hand[low] = base;
        quickSort(hand, start, low - 1);
        quickSort(hand, high + 1, end);
    }
}
