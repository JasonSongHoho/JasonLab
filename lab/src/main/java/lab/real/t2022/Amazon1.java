package lab.real.t2022;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * /**
 * *
 * * 我们需要帮助员工在亚马逊找mentor。这个mentor需要在员工的 4 层好友中寻找到相同职位，职级更高的员工。
 * 我们有一个API getFriends（Emp employee） 会回一个好友列表 (list). 这个列表就是员工的1 层好友。
 * 朋友的朋友是2层好友。
 * <p>
 * // We are working on an application that helps find mentors for Amazon employees.
 * // We want to make recommendations for people that are within 4 (N) degrees of an employee's circle of friends.
 * // mentors have the same role and are more senior than the requested employee.
 * // We are given an API call to get the information about friends for an employee.
 * <p>
 * // Write a method that will take an Employee and return a list of IDs of recommended mentors.
 * <p>
 * /**
 * * This call is provided to you.
 * * Returns only the other employees immediately known to the given employee
 * // *List<Emp> getFriends(Emp employee);
 * //        *
 * //        *
 * //        *
 * //
 * //class Emp {
 * // *
 * //    long id;
 * // *
 * //    String name;
 * // *
 * //    String title; // This will match across employees with the same job.
 * // *
 * //    int level; // A higher number means more senior
 * // *
 * //}
 * // *
 * //         * // Method to implement
 * //         *List<Emp> getSuggestedMentors(Emp loggedIn);
 *
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
