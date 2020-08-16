package lab.leetcode.dailytask;

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
        System.out.println(isValid("()[]{}"));
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
}
