package _12_Data_structure;

import java.util.Stack;

public class exercise_8 {
    public static void main(String[] args) {
        System.out.println(checkValidExpression("4 + (6 * (5 - a)"));
    }

    public static boolean checkValidExpression(String expression){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            if(isParenthesis(expression.charAt(i))){
                if(!stack.isEmpty() && isPairParenthesis(stack.peek(), expression.charAt(i))){
                    stack.pop();
                } else {
                    stack.push(expression.charAt(i));
                }
            }

        }
        return stack.isEmpty();
    }

    public static boolean isPairParenthesis(char x, char y){
        return (x == '(' && y == ')') ||
                (x == '{' && y == '}') ||
                (x == '[' && y == ']');
    }

    public static boolean isParenthesis(char x){
        return x == '(' || x == ')' ||
                x == '{' || x == '}' ||
                x == '[' || x == ']';
    }
}
