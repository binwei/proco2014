package proco2014.novice;

public class NovB_PrimeEvil {
    public static void main(String[] args) {
        int nth = Integer.parseInt(args[0]);

        int candidate = 2;

        for (int index = 1; index < nth; candidate++) {
            // optimization - throw out even numbers early, this way save a call to Math.sqrt
            if (candidate % 2 == 0) {
                continue;
            }
            boolean foundFactor = false;
            // optimization - starts with factor 3 instead of 2
            for (int factor = 3; factor < Math.sqrt(candidate) + 1; factor++) {
                if (candidate % factor == 0) {
                    foundFactor = true;
                    break;
                }
            }

            if (!foundFactor) {
                index++;
            }
        }

        // remember to go back 1
        System.out.println(candidate - 1);
    }
}
