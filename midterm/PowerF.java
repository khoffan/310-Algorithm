public class PowerF {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        long start1 = System.currentTimeMillis();

        System.out.println("calculate x^n use recursive: " + poweRecursive(x, n));

        long now1 = System.currentTimeMillis();
        System.out.println("Elapsed time: " + ((now1 - start1) / 1000.0) + " secs");
        long start2 = System.currentTimeMillis();

        System.out.println("calculate x^n use Divide-and-conquer: " + powerDivide(x, n));

        long now2 = System.currentTimeMillis();
        System.out.println("Elapsed time: " + ((now2 - start2) / 1000.0) + " secs");

    }

    public static int poweRecursive(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * poweRecursive(x, n - 1);
        }
    }

    public static int powerDivide(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = powerDivide(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}
