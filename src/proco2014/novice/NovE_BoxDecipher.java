package proco2014.novice;

public class NovE_BoxDecipher {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String encodedStr = args[2];

        char[][] buf = new char[n][m];

        for (int i = 0; i < encodedStr.length(); i++) {
            int col = i / n;
            int row = i % (m + 1);

            buf[row][col] = encodedStr.charAt(i);
        }

        for (char[] chars : buf) {
            for (char c : chars) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
