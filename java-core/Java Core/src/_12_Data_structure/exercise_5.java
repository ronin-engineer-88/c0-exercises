package _12_Data_structure;

import java.util.Stack;

public class exercise_5 {
    public static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();  // tạo new Stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // trả về giá trị Char của chuỗi tại vị trí có chỉ số index được chỉ định được chỉ định
            if (c == '(' || c == '{' || c == '[' ) {
                myStack.push(c);
            }
            else {
                char getElement = myStack.peek(); // lấy dữ liệu
                if (c == ')' && getElement == '('
                        || c == '}' && getElement == '{'
                        || c == ']' && getElement == '[') {
                    myStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String  s = "()[]{}";
        System.out.println(isValid(s));
    }

}
