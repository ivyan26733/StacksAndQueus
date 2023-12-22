import java.util.Scanner;
import java.util.Stack;

public class stacks1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "(a+b) + ((c+d))";

        //Identify unwanted brackets
        //(a+b) + ((c+d)) --> True(presence of unwanted brackets

        //creation of stack

        Stack<Character> stck = new Stack<>();

        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == ')'){
                if (stck.peek() == '('){
                    System.out.println(true);
                    return;
                }
                else{
                    while(stck.peek()!='('){
                        stck.pop();
                    }

                    stck.pop();
                }
            }
            else{
                stck.push(ch);
            }

        }

        System.out.println(false);


    }
}
