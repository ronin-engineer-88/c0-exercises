package _22_Recursion;

public class Exercise10 {
    public static void main(String[] args) {
        String s = "hello word";
        System.out.println(reverse(s)); 

    }

    public static String reverse(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

}
