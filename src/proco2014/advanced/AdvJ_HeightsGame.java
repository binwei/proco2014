package proco2014.advanced;

import java.util.*;

public class AdvJ_HeightsGame {
    static List<Integer> heights;

    static void createTestInput1() {
        heights = Arrays.asList(-11, 1, 4, 7);
    }

    static void createRandomInput6() {
        Random random = new Random();
        heights = Arrays.asList(
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100)
        );
    }

    public static void main(String[] args) {
        createTestInput1();
        assert (heights.size() % 2 == 0);

        Collections.sort(heights);
        System.out.println(heights);

        List<Integer> workingList = new ArrayList<Integer>(heights);

        while (workingList.size() >= 4) {
            // take the (first, last) pair, and (second, second last) pair out of the working list
            int sum1 = workingList.get(0) + workingList.get(workingList.size() - 1);
            int sum2 = workingList.get(1) + workingList.get(workingList.size() - 2);

            List<Integer> newWorkingList = new ArrayList<Integer>(workingList.subList(2, workingList.size() - 2));

            // now add sum1 and sum2
            newWorkingList.add(sum1);
            newWorkingList.add(sum2);

            Collections.sort(newWorkingList);

            workingList = newWorkingList;
            System.out.println(workingList);
        }

        System.out.println(workingList.get(1) - workingList.get(0));
    }
}



