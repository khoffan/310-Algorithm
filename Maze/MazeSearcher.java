// MazeSearcher.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Dec 2022
/* 
   Usage:
      java MazeSearcher maze1.txt    (maze2.txt)
*/

import java.io.*;
import java.util.*;

public class MazeSearcher {
    private static final int[][] STEPS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // (dx, dy)
    // DOWN RIGHT UP LEFT

    public MazeSearcher(Maze maze) {
        ArrayList<Coord> path = new ArrayList<>();
        Coord entry = maze.getStart();
        if (explore(maze, entry.getX(), entry.getY(), path)) {
            maze.printPath(path);
        } else
            System.out.println("No path found");
    } // end of MazeSearcher()

    private boolean explore(Maze maze, int x, int y, ArrayList<Coord> path) {
        if (!maze.isValidLoc(x, y) || maze.isWall(x, y)) {
            return false;
        }

        if (maze.isExit(x, y)) {
            path.add(new Coord(x, y));
            return true;
        }
        if (maze.wasVisited(x, y)) {
            return false;
        }
        path.add(new Coord(x, y));
        maze.setVisited(x, y);
        for (int[] step : STEPS) {
            int dx = step[0];
            int dy = step[1];
            if (explore(maze, x + dx, y + dy, path)) {
                return true;
            }

        }
        // if (explore(maze, x - 1, y, path)) {
        // return true;
        // }
        // if (explore(maze, x, y - 1, path)) {
        // return true;
        // }
        path.remove(path.size() - 1);
        return false;
    } // end of explore()

    // Students: you can add other functions if you wish

    // --------------------------------------------

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            System.out.println("Usage: java MazeSearcher <maze textfile>");
        else {
            Maze maze = new Maze(new File(args[0]));
            MazeSearcher dfs = new MazeSearcher(maze);
        }
    }

} // end of MazeSearcher class
