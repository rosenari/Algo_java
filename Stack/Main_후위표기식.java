package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_후위표기식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] input = br.readLine().trim().toCharArray();
        for(int i = 0; i < input.length; i++){
            if(input[i] == '+' || input[i] == '-'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    System.out.print(stack.pop());
                }
                stack.push(input[i]);
            }else if(input[i] == '*' || input[i] == '/'){
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    System.out.print(stack.pop());
                }
                stack.push(input[i]);
            }else if(input[i] == '('){
                stack.push(input[i]);
            }else if(input[i] == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    System.out.print(stack.pop());
                }
                stack.pop();
            }else{
                System.out.print(input[i]);
            }
        }
        while(!stack.isEmpty()) System.out.print(stack.pop());
    }
}
