// VDist.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, DEc 2020

/* Holds a vertexID and distTo distance;
   Used to stored data in a priority queue in Dijkstra.java 
*/

public class VDist implements Comparable<VDist> {
  private int id, dist;

  public VDist(int id, int dist) {
    this.id = id;
    this.dist = dist;
  }

  public int getID() {
    return id;
  }

  public int getDist() {
    return dist;
  }

  public String toString() {
    return "(v:" + id + ",d:" + dist + ")";
  }

  @Override
  public int compareTo(VDist vd)
  // used by the priority queue
  {
    return Integer.compare(dist, vd.dist);
  }

} // end of VDist class