package proco2014.novice;

public class NovK_ShootingSpiders {
    static int[] spiders;

    static void createSampleInput1() {
        spiders = new int[]{
                1, 2, 3, 2, 4, 5, 1, 2, 4, 3
        };
    }

    static void createSampleInput2() {
        spiders = new int[]{
                10, 20, 30, 40, 50, 40, 30, 20, 10, 1
        };
    }

    static void parseInput(String file) {
        // TBD
    }

    public static void main(String[] args) {

        createSampleInput2();

        int round = 0;
        int index = 0;

        while (index < spiders.length) {
            if (spiders[index] == 0) {
                index++;
                continue;
            }

            for (int i = index; i < spiders.length && spiders[i] > 0; i++) {
                spiders[i]--;
            }

            round++;
        }

        System.out.println(round);
    }
}
