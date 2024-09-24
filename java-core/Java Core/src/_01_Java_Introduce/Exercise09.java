package _01_Java_Introduce;

public class Exercise09 {
    public static void main(String[] args) {
    /*
        Xâ dựng công thức:
        Coi số dân hiện tại là A, số giây trong một năm là B
        Sau 7 giây có 1 ca sinh => 1 năm sẽ có B/7 ca sinh
        Sau 13 giây có 1 người chết => 1 năm sẽ có B/ 13 người chết
        45 giây có một người nhập cư mới => 1 năm sẽ có B/ 45 người nhập cư mới
        => Sau mỗi năm, dân số sẽ biến động: B/7 - B/13 + B/45 = B(1/7 - 1/13 + 1/45)

        => Sau một năm, dân số sẽ là: A + B(1/7 - 1/13 + 1/45)
           Sau hai năm, dân số sẽ là: A + B(1/7 - 1/13 + 1/45) + B(1/7 - 1/13 + 1/45)
                                       = A + 2xBx(1/7 - 1/13 + 1/45)
           Sau ba năm, dân số sẽ là: A + 3xBx(1/7 - 1/13 + 1/45)
           ........
           Sau năm năm, dân số sẽ là: A + 5xBx(1/7 - 1/13 + 1/45)
    */

      //Đổi đơn vị: 1 năm = 365 x 24 x 60 x 60

        System.out.println("Dân số hiện nay là 312.032.486");
        System.out.printf("Dân số sau một năm sẽ là: %.2f\n", (312_032_486 + 1*(365*24*60*60)*(1.0/7 - 1.0/13 + 1.0/45)));
        System.out.printf("Dân số sau hai năm sẽ là: %.2f\n", (312_032_486 + 2*(365*24*60*60)*(1.0/7 - 1.0/13 + 1.0/45)));
        System.out.printf("Dân số sau ba năm sẽ là: %.2f\n", (312_032_486 + 3*(365*24*60*60)*(1.0/7 - 1.0/13 + 1.0/45)));
        System.out.printf("Dân số sau bốn năm sẽ là: %.2f\n", (312_032_486 + 4*(365*24*60*60)*(1.0/7 - 1.0/13 + 1.0/45)));
        System.out.printf("Dân số sau năm năm sẽ là: %.2f\n", (312_032_486 + 5*(365*24*60*60)*(1.0/7 - 1.0/13 + 1.0/45)));
    }
}
