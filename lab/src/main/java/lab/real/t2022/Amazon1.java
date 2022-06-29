package lab.real.t2022;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/29
 */
public class Amazon1 {
    public static void main(String[] args) {
        System.out.println("a:" + check("a"));
        System.out.println("((a)):" + check("((a))"));
        System.out.println("[a(b)]:" + check("[a(b)]"));
        System.out.println("[()[()]]:" + check("[()[()]]"));
        System.out.println("[[()]()]:" + check("[[()]()]"));
    }

    public static boolean check(String s) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> tmpStack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                if (c == '{') {
                    if (!stack.isEmpty()) {
                        return false;
                    }
                    stack.push(c);
                } else if (c == '[') {
                    if (!stack.isEmpty() && stack.peek() != '{') {
                        return false;
                    }
                    tmpStack.push('[');
                } else {
                    if (!stack.isEmpty() && stack.peek() != '[') {
                        return false;
                    }
                    tmpStack.push('(');
                }
            }
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (c != map.get(last)) {
                    return false;
                }
                if (c == ')' && !tmpStack.isEmpty()) {
                    return false;
                }
                Character lastEnd = tmpStack.pop();
                if (c == '}' && lastEnd != ']') {
                    return false;
                }
                if (c == ']' && lastEnd != ')') {
                    return false;
                }
                if (!stack.isEmpty()) {
                    tmpStack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
