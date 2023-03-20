import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int capacity = 50;

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        Collections.sort(items);

        int maxProfit = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxProfit += item.value;
                capacity -= item.weight;
            } else {
                maxProfit += capacity * item.value / item.weight;
                break;
            }
        }

        System.out.println(maxProfit);
    }

    private static class Item implements Comparable<Item> {
        private final int weight;
        private final int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item other) {
            double ratio = (double) other.value / other.weight - (double) value / weight;
            return Double.compare(ratio, 0);
        }
    }
}
