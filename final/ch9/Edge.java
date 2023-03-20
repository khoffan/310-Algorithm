public class Edge {
    private int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "(" + from + "->" + to + "," + weight + ")";
    }

} // end of Edge class
