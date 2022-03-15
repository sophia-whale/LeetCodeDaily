package Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer30 {
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if(minStack.empty() || minStack.peek() >= x)
                minStack.add(x);
            stack.add(x);
        }

        public void pop() {
            if(stack.pop().equals(minStack.peek()))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {

    }
}
