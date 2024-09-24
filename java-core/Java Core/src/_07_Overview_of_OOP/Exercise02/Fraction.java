package _07_Overview_of_OOP.Exercise02;

import static _05_Arrays_TextIO.homework.exercise_7.gcd;

public class Fraction {
    private int numerator;
    private int denominator;
    private boolean isValid;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0) {
            this.isValid = false;
        } else {
            this.isValid = true;
            this.denominator = denominator;
        }
    }

    // Phương thức rút gọn phân số
    public void reduce(){
        if(!isValid) {
            System.out.println("Cannot reduce the fraction!");
        } else {
            int gcd = gcd(numerator, denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;
        }
    }

    //  Phương thức trả về giá trị phân số dưới dạng chuỗi
    @Override
    public String toString(){
        if(!isValid)
            return "Invalid fraction!";
        return numerator + "/" + denominator;
    }

    // Phương thức cộng phân số khác
    public Fraction add(Fraction f){
        if(!this.isValid || !f.isValid){
            System.out.println("Cannot add because one of this two fraction is invalid!");
            return null;
        } else {
            int newNumerator = this.numerator * f.getDenominator()
                    + f.getNumerator() * this.getDenominator();
            int newDenominator = this.denominator * f.getDenominator();

            Fraction result = new Fraction(newNumerator, newDenominator);
            result.reduce();

            return result;
        }
    }

    // Phương thức trừ phân số khác
    public Fraction subtract(Fraction f){
        if(!this.isValid || !f.isValid) {
            System.out.println("Cannot subtract because one of this two fraction is invalid!");
            return null;
        } else {
            int newNumerator = this.numerator * f.getDenominator()
                    - f.getNumerator() * this.getDenominator();
            int newDenominator = this.denominator * f.getDenominator();

            Fraction result = new Fraction(newNumerator, newDenominator);
            result.reduce();

            return result;
        }

    }

    // Phương thức nhân phân số khác
    public Fraction multiply(Fraction f){
        if(!this.isValid || !f.isValid) {
            System.out.println("Cannot multiply because one of this two fraction is invalid!");
            return null;
        } else {
            int newNumerator = this.numerator * f.getNumerator();
            int newDenominator = this.denominator * f.getDenominator();
            Fraction result = new Fraction(newNumerator, newDenominator);
            result.reduce();

            return result;
        }


    }

    // Phương thức chia phân số khác
    public Fraction divide(Fraction f){
        if(!this.isValid || !f.isValid) {
            System.out.println("Cannot subtract because one of this two fraction is invalid!");
            return null;
        } else {
            int newNumerator = this.numerator * f.getDenominator();
            int newDenominator = this.denominator * f.getNumerator();
            Fraction result = new Fraction(newNumerator, newDenominator);
            result.reduce();

            return result;
        }
    }

    private int gcd(int numerator, int denominator){
        if(denominator == 0)
            return numerator;

        return gcd(denominator, numerator%denominator);
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
