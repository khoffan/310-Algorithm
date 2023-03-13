public class DVD {

    private String Title, Director, Comment;
    private int playingtime;
    private boolean gotIt;

    public DVD(String thetitle, String director, int time) {
        Title = thetitle;
        Director = director;
        playingtime = time;
        Comment = null;
        gotIt = false;
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
        System.out.print("DVD: " + Title + " (" + playingtime + "mins)");
        if (gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("     " + Director);
        if (Comment != null) {
            System.out.println("    " + Comment);
        }
    }
}