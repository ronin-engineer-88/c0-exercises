package _01_Java_Introduce;

public class Exercise10 {
    public static void main(String[] args) {

    /*
        Quy tắc Cramer để giải hệ phương trình ax + by = e, cx + dy = f
        x = (e*d - b*f) / (a*d - b*c)
        y = (a*f - e*c) / (a*d - b*c)
    */

        System.out.println("Nghiệm của hệ phương trình 3.4x + 50.2y = 44.5 và 2.1x + .55y = 5.9 là:");
        // a = 3.4, b = 50.2, c = 2.1, d = 0.55, e = 44.5, f = 5.9
        System.out.printf("x: %.2f\n", (44.5*.55 - 50.2*5.9) / (3.4*.55 - 50.2*2.1));
        System.out.printf("y: %.2f\n", (3.4*5.9 - 44.5*2.1) / (3.4*.55 - 50.2*2.1));

    }
}
