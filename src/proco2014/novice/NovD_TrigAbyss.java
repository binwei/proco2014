package proco2014.novice;

public class NovD_TrigAbyss {
    public static void main(String[] args) {
        int level = Integer.parseInt(args[0]);

        assert (level % 2 == 1);

        for (int i = 0; i < level / 2; i++) {
            // 1, 2, 3, etc
            for (int x = 0; x < i + 1; x++) {
                System.out.print("x");
            }
            // ... 5, 3, 1
            for (int d = 0; d < level - 2 * (i + 1); d++) {
                System.out.print(".");
            }
            for (int x = 0; x < i + 1; x++) {
                System.out.print("x");
            }
            System.out.println();
        }
        for (int x = 0; x < level; x++) {
            System.out.print("x");
        }
        System.out.println();
    }
}
