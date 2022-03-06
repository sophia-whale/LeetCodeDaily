package Offer;

import java.util.Stack;

public class CQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> reStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (!reStack.isEmpty()) return reStack.pop();
        while (!stack.isEmpty()) {
            reStack.push(stack.pop());
        }
        if (reStack.isEmpty()) return -1;
        return reStack.pop();
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
