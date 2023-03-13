import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Student std = new Student(10);
        // int i = 1;
        // while (true) {
        // Scanner scan = new Scanner(System.in);
        // System.out.print("Enter name: ");
        // String name = scan.nextLine();
        // std.set_Name(name);
        // i++;
        // if (i == 10) {
        // std.get_fname();
        // break;
        // }
        // }

        Databse db = new Databse();

        CD beatle = new CD("Album 2", "The Beatle", 13, 122);
        db.addCD(beatle);
        beatle.setComment("The album of best in the world");

        db.addCD(new CD("marison", "the door", 11, 109));
        db.addCD(new CD("feel the son", "yorn", 9, 100));

        db.addDVD(new DVD("awaken", "steven king", 100));

        DVD drs = new DVD("dr. strnger", "kane", 120);
        drs.setComment("magic of the world");
        db.addDVD(drs);

        db.addDVD(new DVD("ironman", "michael bays", 200));

        db.list();
    }
}
