import java.io.*;

public class Main {
    public static void main(String[] args) {
        Stack stk1 = new Stack(10);

        stk1.push(10);
        stk1.push(20);
        stk1.pop();
        System.out.println(stk1.topOf());
    }
}
