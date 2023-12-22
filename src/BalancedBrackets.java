import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "[(a+b) + {(c+d) * (e+f)}]";
        boolean val = true;
        Stack<Character> stck = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stck.push(ch);
            } else if (ch == ')') {
                if (stck.isEmpty() || stck.pop() != '(') {
                    val = false;
                    break;
                }
            } else if (ch == '}') {
                if (stck.isEmpty() || stck.pop() != '{') {
                    val = false;
                    break;
                }
            } else if (ch == ']') {
                if (stck.isEmpty() || stck.pop() != '[') {
                    val = false;
                    break;
                }
            }
        }

        if (!stck.isEmpty()) {
            val = false;
        }

        System.out.println(val);
    }
}
