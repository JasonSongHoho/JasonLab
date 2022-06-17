package lab.leetcode;

import java.util.Stack;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/17
 */
public class E232 {
    public class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(int x) {
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }
            pushStack.push(x);
        }

        public int pop() {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }

        public int peek() {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.peek();
        }

        public boolean empty() {
            return popStack.isEmpty() && pushStack.isEmpty();
        }
    }
}
