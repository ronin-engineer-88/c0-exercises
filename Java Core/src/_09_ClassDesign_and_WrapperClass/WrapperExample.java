package _09_ClassDesign_and_WrapperClass;

public class WrapperExample {
    public static void main(String[] args) {
        Integer autoBoxedNum = 1000;
        int autoUnboxedNum = autoBoxedNum;
        System.out.println("Auto-boxed Integer: " + autoBoxedNum);
        System.out.println("Auto-unboxed int: " + autoUnboxedNum);
    }
}
