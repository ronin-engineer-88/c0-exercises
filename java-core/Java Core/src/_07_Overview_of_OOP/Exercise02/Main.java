package _07_Overview_of_OOP.Exercise02;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(4, 6);
        Fraction f2 = new Fraction(5, 0);
        Fraction f3 = new Fraction(1, 2);

        System.out.println("Fraction f1 before reduce: " + f1);
        f1.reduce();
        System.out.println("Fraction f1 after reduce: " + f1);
        System.out.println("-------------------------------------------------");

        System.out.println("Operation of two fraction " + f1 + " and " + f3);
        System.out.println("Sum: " + f1.add(f3));
        System.out.println("Difference: " + f1.subtract(f3));
        System.out.println("Product: " + f1.multiply(f3));
        System.out.println("Quotient: " + f1.divide(f3));
        System.out.println("-------------------------------------------------");

        System.out.println("Operation of two fraction " + f2 + " and " + f3);
        System.out.println("Sum: " + f2.add(f3));
        System.out.println("Difference: " + f2.subtract(f3));
        System.out.println("Product: " + f2.multiply(f3));
        System.out.println("Quotient: " + f2.divide(f3));
    }
}
