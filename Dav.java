/**
 * Dav
 */
public class Dav {

    public static void main(String[] args) {
        int d = Integer.parseInt(args[0]);
        StringBuilder sb = new StringBuilder();
        generatedavison(d, sb);
        System.out.println(sb.toString());
    }

    public static void generatedavison(int d, StringBuilder sb) {
        if (d == 0) {
            sb.append('0');
            return;
        }
        generatedavison(d - 1, sb);
        sb.append(neg(sb.toString()));
    }

    public static String neg(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}