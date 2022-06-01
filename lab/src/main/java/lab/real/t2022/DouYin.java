package lab.real.t2022;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/31
 */
@Slf4j
public class DouYin {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        System.out.println(topK("19999", "1"));
        System.out.println(topK("99999", "1"));

    }

    public static String topK(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int temp = 0, pre = 0;
        char c1, c2;
        for (int i = m-1, j = n-1; i >=0 || j >= 0;) {
            if(i >=0){
                c1 = a.charAt(i);
                i--;
            }else{
                c1 = '0';
            }
            if(j >=0){
                c2 = b.charAt(j);
                j--;
            }else{
                c2 = '0';
            }
            temp = pre +  (c1 - '0') + (c2 - '0');
            pre = temp /10;
            temp = temp % 10;
            ans.insert(0, temp);
        }
        if(pre > 0){
            ans.insert(0, pre);
        }
        return ans.toString();
    }
}
