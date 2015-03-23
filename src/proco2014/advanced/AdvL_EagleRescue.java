package proco2014.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdvL_EagleRescue {
    static List<Location> eagleLocations;
    static int kNearest;

    static void createTestInput1() {
        eagleLocations = Arrays.asList(
                new Location(2, 1),
                new Location(1, 3),
                new Location(5, 3)
        );
        kNearest = 2;
    }

    static void createTestInput2() {
        eagleLocations = Arrays.asList(
                new Location(0, 1),
                new Location(1, 2),
                new Location(2, 0)
        );
        kNearest = 3;
    }

    static void parseInput() {
        // TBD
    }

    public static void main(String[] args) {

        createTestInput2();

        List<Double> xPositions = new ArrayList<Double>();
        List<Double> yPositions = new ArrayList<Double>();

        for (Location eagleLocation : eagleLocations) {
            xPositions.add(eagleLocation.x);
            yPositions.add(eagleLocation.y);
        }

        Collections.sort(xPositions);
        Collections.sort(yPositions);

        double shortestDistance = Double.MAX_VALUE;

        for (int segmentStart = 0; segmentStart <= eagleLocations.size() - kNearest; segmentStart++) {
            // form a segment [segmentStart, segmentStart + kNearest) and find the median of the segment
            Location median;
            if (kNearest % 2 == 0) {
                final int leftMedian = segmentStart + kNearest / 2 - 1;
                median = new Location(
                        (xPositions.get(leftMedian) + xPositions.get(leftMedian + 1)) / 2,
                        (yPositions.get(leftMedian) + yPositions.get(leftMedian + 1)) / 2);
            } else {
                final int medianAt = segmentStart + (kNearest - 1) / 2;
                median = new Location(xPositions.get(medianAt), yPositions.get(medianAt));
            }

            // calc the distances and sort them
            List<Double> distances = new ArrayList<Double>();
            for (Location eagleLocation : eagleLocations) {
                distances.add(eagleLocation.distance(median));
            }
            Collections.sort(distances);

            // take the nearest K and sum up
            double segmentDistance = 0.0;
            for (int i = 0; i < kNearest; i++) {
                segmentDistance += distances.get(i);
            }

            if (segmentDistance < shortestDistance) {
                shortestDistance = segmentDistance;
                System.out.println("Found shortest distance " + shortestDistance + " with point x=" + median.x + " y=" + median.y);
            }
        }
    }
}

class Location {
    final double x;
    final double y;

    Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(Location location) {
        return Math.abs(x - location.x) + Math.abs(y - location.y);
    }
}
