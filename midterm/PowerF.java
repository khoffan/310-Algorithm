public class PowerF {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.print(power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }
}
