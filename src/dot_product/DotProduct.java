import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;

        int n = a.length;

        if (n != 0) {
            // get boundary values in a and b
            int minA = a[0];
            int maxA = a[0];
            int minB = b[0];
            int maxB = b[0];
            for (int i = 0; i < n; i++) {
                int ai = a[i];
                int bi = b[i];

                if (ai < minA) {
                    minA = ai;
                }
                if (ai > maxA) {
                    maxA = ai;
                }
                if (bi < minB) {
                    minB = bi;
                }
                if (bi > maxB) {
                    maxB = bi;
                }
            }
            // These are the flag values.
            // Encountering them in an array means
            // the value at this position was already used.
            int maxmaxA = maxA + 1;
            int minminB = minB - 1;

            // These are the initialization values.
            int minminA = minA - 1;
            int maxmaxB = maxB + 1;

            for (int i = 0; i < n; i++) {
                maxA = minminA;
                minB = maxmaxB;

                int indexMaxA = -1;
                int indexMinB = -1;

                for (int j = 0; j < n; j++) {
                    int aj = a[j];
                    int bj = b[j];

                    if ((aj != maxmaxA) && (aj > maxA)) {
                        indexMaxA = j;
                        maxA = aj;
                    }
                    if ((bj != minminB) && (bj < minB)) {
                        indexMinB = j;
                        minB = bj;
                    }
                }

                if ((indexMaxA != -1) && (indexMinB != -1)) {
                    result += (long)a[indexMaxA] * b[indexMinB];

                    a[indexMaxA] = maxmaxA;
                    b[indexMinB] = minminB;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}

