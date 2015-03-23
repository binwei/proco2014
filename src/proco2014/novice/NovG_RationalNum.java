package proco2014.novice;

import java.util.Arrays;
import java.util.List;

public class NovG_RationalNum {
    static List<RationalNumber> rationalNumbers;

    static void createTestInput1() {
        rationalNumbers = Arrays.asList(
                new RationalNumber(10, 3),
                new RationalNumber(5, 2),
                new RationalNumber(-4, 2),
                new RationalNumber(-1, 2),
                new RationalNumber(4, 6)
        );
    }

    static void parseInput(String fileName) {
        // TBD
    }

    public static void main(String[] args) {
        createTestInput1();

        int commonDenominator = 1;

        for (RationalNumber rationalNumber : rationalNumbers) {
            rationalNumber.simplify();
            commonDenominator = lcm(rationalNumber.denominator, commonDenominator);
        }

        int sumNumerator = 0;

        for (RationalNumber rationalNumber : rationalNumbers) {
            sumNumerator += commonDenominator / rationalNumber.denominator * rationalNumber.numerator;
        }

        RationalNumber result = new RationalNumber(sumNumerator, commonDenominator);
        result.simplify();

        System.out.println(result);
    }

    // it helps to be familiar with the GCD and LCM implementations
    static int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}

class RationalNumber {
    int numerator;
    int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    void simplify() {
        int gcd = NovG_RationalNum.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }
}
