
// AdjNode.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Dec. 2020

import java.util.*;

public class AdjNode implements Comparator<AdjNode> {
    private int id;
    private int weight = 0;
    /*
     * the weight of the edge coming to this node
     * If the weight is 0 then the edge is unweighted.
     */

    public AdjNode(int id) {
        this.id = id;
    }

    public AdjNode(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getID() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        if (weight != 0)
            return "(" + id + "," + weight + ")";
        else
            return "(" + id + ")";
    }

    @Override
    public int compare(AdjNode node1, AdjNode node2)
    // order by increasing weight
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }

} // end of AdjNode class