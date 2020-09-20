package lab.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @author jasonsong
 * 2020/9/20
 */


public class E155 {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static class MinStack {
        private LinkedList<Integer> linkedList;
        private LinkedList<Integer> minStack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            linkedList = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            System.out.println(minStack.getMin());
            minStack.pop();
            System.out.println(minStack.top());
            System.out.println(minStack.getMin());

        }

        public void push(int x) {
            linkedList.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }

        public void pop() {
            linkedList.pop();
            minStack.pop();
        }

        public int top() {
            return linkedList.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
