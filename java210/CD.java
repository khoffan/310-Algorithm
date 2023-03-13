public class CD {

    private String Title, Artist, Comment;
    private int numberOftarck, playingtime;
    private boolean gotIt;

    public CD(String thetitle, String theartist, int tracks, int time) {
        Title = thetitle;
        Artist = theartist;
        numberOftarck = tracks;
        playingtime = time;
        gotIt = false;
        Comment = null;
    }

    public void setComment(String com) {
        Comment = com;
    }

    public String getComment() {
        return Comment;
    }

    public void setOwn(boolean own) {
        gotIt = own;
    }

    public boolean getOwn() {
        return gotIt;
    }

    public void print() {
        System.out.print("CD: " + Title + " (" + playingtime + "mins)");
        if (gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("   " + Artist);
        System.out.println("   Track: " + numberOftarck);
        if (Comment != null) {
            System.out.println("   " + Comment);
        }
    }

}
