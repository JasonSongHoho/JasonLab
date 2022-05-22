package lab.leetcode.dailytask;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jasonsong
 * 2020/8/14
 */


public class E20 {
    static Map<Character, Character> dictionary = new HashMap<>(4);

    public static void main(String[] args) {
        System.out.println(isValid1("{()[}]"));
        System.out.println(isValid1("()[]{}"));
    }

    public static boolean isValid(String s) {
        dictionary.put('(', ')');
        dictionary.put('[', ']');
        dictionary.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c != dictionary.get(pop)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('0');
        char top;
        char cur;
        for (int i = 0; i < len; i++) {
            top = stack.peek();
            cur = s.charAt(i);
            if (top != '0' && map.get(top) == cur) {
                stack.pop();
            } else {
                if (!map.containsKey(cur)) {
                    return false;
                }
                stack.push(cur);
            }
        }
        return stack.size() == 1;
    }

}
