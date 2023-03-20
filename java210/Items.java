import java.util.*;

public class Items {
    public static void main(String[] args) {
        Data db = new Data();

        CD beatle = new CD("Album 2", "The Beatle", 13, 122);
        db.addItem(beatle);
        beatle.setComment("The album of best in the world");

        db.addItem(new CD("marison", "the door", 11, 109));
        db.addItem(new CD("feel the son", "yorn", 9, 100));

        db.addItem(new DVD("awaken", "steven king", 100));

        DVD drs = new DVD("dr. strnger", "kane", 120);
        drs.setComment("magic of the world");
        db.addItem(drs);

        db.addItem(new DVD("ironman", "michael bays", 200));

        db.list();
    }
}

class Item {
    private String title, comment;
    private int playingtime;
    private boolean gotIt;

    public Item(String thetile, int time) {
        title = thetile;
        playingtime = time;
        comment = null;
        gotIt = false;
    }

    public void setComment(String com) {
        comment = com;
    }

    public String getComment() {
        return comment;
    }

    public void setOwn(boolean own) {
        gotIt = own;
    }

    public boolean getOwn() {
        return gotIt;
    }

    public void print() {
        System.out.print("Title: " + title + " (" + playingtime + "mins)");
        if (gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        if (comment != null) {
            System.out.println("   " + comment);
        }
    }
}

class CD extends Item {
    private String Artist;
    private int numTracks;

    public CD(String thetitle, String artist, int track, int time) {
        super(thetitle, time);
        Artist = artist;
        numTracks = track;
    }

    public String getArtist() {
        return Artist;
    }

    public int getnumTrack() {
        return numTracks;
    }
}

class DVD extends Item {
    private String director;

    public DVD(String thetitle, String thedirector, int time) {
        super(thetitle, time);
        director = thedirector;
    }

    public String getDirector() {
        return director;
    }
}

class Data {
    private ArrayList<Item> items;

    public Data() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item theitem) {
        items.add(theitem);
    }

    public void list() {
        for (Item item : items) {
            item.print();
        }
    }

}

// give me code example for STP of diijstra algorithm
