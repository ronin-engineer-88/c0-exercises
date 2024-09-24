package _10_Exception.homework;

public class exercise_1 {
    public static void main(String[] args) {
        try {
            m(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void m(int value) throws Exception {
        if (value < 40) {
            throw new Exception("value is too small");
        }
    }
}

// Homework 01

 /*Vấn đề: method m đang ném ra một exception checked.
           Mình cần sử dụng từ khóa throws trong khai báo phương thức.*/