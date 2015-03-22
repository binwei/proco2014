package proco2014.novice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NovF_Shopping {
    static double budget;
    static List<Item> items;

    static void createSampleInputWith3Items() {
        budget = 2.5;

        items = Arrays.asList(
                new Item(2.0, 1.0),
                new Item(0.5, 2.0),
                new Item(6.0, 2.5)
        );
    }

    static void createSampleInputWith5Items() {
        budget = 4.0;

        items = Arrays.asList(
                new Item(1.0, 2.0),
                new Item(5.0, 2.5),
                new Item(2.0, 1.2),
                new Item(3.0, 1.0)
        );
    }

    static void parseInputFile(String inputFile) {
        // TBD
    }

    public static void main(String[] args) {
        createSampleInputWith3Items();

        Collections.sort(items);

        double balance = budget;
        double value = 0.0;

        for (int i = 0; i < items.size() && balance > 0; i++) {
            if (balance >= items.get(i).price) {
                value += items.get(i).value;
                balance -= items.get(i).price;
            } else {
                value += items.get(i).getValuePriceRatio() * balance;
                balance = 0;
            }
        }

        System.out.println(value);
    }
}

class Item implements Comparable<Item> {
    final double price;
    final double value;

    Item(double price, double value) {
        this.price = price;
        this.value = value;
    }

    public Double getValuePriceRatio() {
        return value / price;
    }

    @Override
    public int compareTo(Item o) {
        return o.getValuePriceRatio().compareTo(getValuePriceRatio());
    }
}
