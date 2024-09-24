package _09_ClassDesign_and_WrapperClass;

import java.math.BigInteger;

public class BigIntegerExample {
    public static void main(String[] args) {
        BigInteger bigInt1 = new BigInteger("12345678901234567890");
        BigInteger bigInt2 = new BigInteger("98765432109876543210");
        BigInteger bigIntSum = bigInt1.add(bigInt2);
        BigInteger bigIntProduct = bigInt1.multiply(bigInt2);

        System.out.println("BigInteger Sum: " + bigIntSum);
        System.out.println("BigInteger Product: " + bigIntProduct);
    }
}
