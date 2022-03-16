package Offer;

import java.util.Stack;

public class Offer31 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
        System.out.println(validateStackSequencesNon(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int length = pushed.length;
        int push = 0;
        int pop = 0;
        while (push < length) {
            if (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
                continue;
            }
            stack.push(pushed[push]);
            push++;
        }

        int remain = stack.size();
        for (int i = 0; i < remain; i++) {
            if (stack.peek() == popped[pop++]) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static boolean validateStackSequencesNon(int[] pushed, int[] popped) {
        int push = 0;
        int pop = 0;
        // 将pushed数组作为栈
        for (int cur : pushed) {
            pushed[push] = cur;
            while (push >= 0 && pushed[push] == popped[pop]) {
                pop++;
                push--;
            }
            push++;
        }
        return push == 0;
    }
}
