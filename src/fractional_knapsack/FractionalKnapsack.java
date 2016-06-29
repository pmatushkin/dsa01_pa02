import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here

        int n = values.length;

        while (capacity > 0) {
            int bestItem = -1;
            int currentItem = 0;
            double currentBestValue = 0;

            while (currentItem < n) {
                if (weights[currentItem] > 0) {
                    double currentValue = (double)values[currentItem] / weights[currentItem];

                    if (currentValue > currentBestValue) {
                        currentBestValue = currentValue;
                        bestItem = currentItem;
                    }
                }

                currentItem++;
            }

            // can't find the best item because capacity exceeds the total of weights
            if (-1 == bestItem) {
                capacity = 0;
            } else {
                int availableWeight = weights[bestItem];

                if (capacity > availableWeight) {
                    capacity = capacity - availableWeight;
                    weights[bestItem] = 0;
                    value = value + values[bestItem];
                } else {
                    value = value + ((double)values[bestItem] / availableWeight) * capacity;
                    capacity = 0;
                }
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(getOptimalValue(capacity, values, weights)));
    }
} 
