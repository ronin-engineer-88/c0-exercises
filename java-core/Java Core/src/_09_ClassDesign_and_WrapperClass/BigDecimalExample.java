package _09_ClassDesign_and_WrapperClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExample {
    public static void main(String[] args) {
        BigDecimal bigDec1 = new BigDecimal("12345.6789");
        BigDecimal bigDec2 = new BigDecimal("9876.5432");
        BigDecimal bigDecSum = bigDec1.add(bigDec2);
        BigDecimal bigDecDifference = bigDec1.subtract(bigDec2);
        BigDecimal bigDecProduct = bigDec1.multiply(bigDec2);
        BigDecimal bigDecQuotient = bigDec1.divide(bigDec2, RoundingMode.HALF_UP);

        System.out.println("BigDecimal Sum: " + bigDecSum);
        System.out.println("BigDecimal Difference: " + bigDecDifference);
        System.out.println("BigDecimal Product: " + bigDecProduct);
        System.out.println("BigDecimal Quotient: " + bigDecQuotient);
    }
}
