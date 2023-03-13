import java.util.*;

public class Databse {
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    public Databse() {
        cds = new ArrayList<CD>();
        dvds = new ArrayList<DVD>();
    }

    public void addCD(CD thecd) {
        cds.add(thecd);
    }

    public void addDVD(DVD thedvd) {
        dvds.add(thedvd);
    }

    public void list() {
        for (CD cd : cds) {
            cd.print();
        }
        System.out.println("---------------");
        for (DVD dvd : dvds) {
            dvd.print();
        }
    }
}
