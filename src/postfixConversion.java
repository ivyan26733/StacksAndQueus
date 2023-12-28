import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfixConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();


        Stack<String> instck = new Stack<>();
        Stack<String> prestck = new Stack<>();
        Stack<Integer> valstck = new Stack<>();

        for (int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);

            if (ch == '+' || ch=='-' || ch=='*' || ch=='/'){
                int val2 = valstck.pop();
                int val1 = valstck.pop();
                int ans1 = operations(val1, val2 , ch);
                valstck.push(ans1);

                String val4 = prestck.pop();
                String val3 = prestck.pop();
                String ans2 = ch + val3 + val4;
                prestck.push(ans2);


                String val6 = instck.pop();
                String val5 = instck.pop();
                String ans3 = '(' + val5 +ch+val6 + ')';
                instck.push(ans3);
            }else{
                valstck.push(ch - '0');
                prestck.push(ch + " ");
                instck.push(ch + " ");
            }

        }


        System.out.println(valstck.pop());
        System.out.println(instck.pop());
        System.out.println(prestck.pop());
    }


//    public static int precedence(char ch){
//        if (ch == '+' || ch == '-'){
//            return 1;
//        }else if(ch == '*' || ch == '/'){
//            return 2;
//        }else{
//            return 0;
//        }
//    }

    public static int operations(int val1 , int val2 , char ch){
        if (ch == '+'){
          return val1 + val2;
        } else if (ch == '-'){
            return val1 - val2;
        } else if (ch == '*'){
            return val1 * val2;
        } else if (ch == '/'){
            return val1/val2;
        }
        else{
            return 0;
        }

    }
}
