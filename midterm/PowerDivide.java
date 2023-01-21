public class PowerDivide {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.println("power: " + power(x, n));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = power(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
}
