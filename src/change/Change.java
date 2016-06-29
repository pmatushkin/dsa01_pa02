import java.util.Scanner;

public class Change {

    private static int getChange(int n) {
        //write your code here
        final int c1 = 1;
        final int c5 = 5;
        final int c10 = 10;

        int c = 0;
        while (n != 0) {
            if (n >= c10) {
                n = n - c10;
            } else if (n >= c5) {
                n = n - c5;
            } else {
                n = n - c1;
            }

            c++;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

