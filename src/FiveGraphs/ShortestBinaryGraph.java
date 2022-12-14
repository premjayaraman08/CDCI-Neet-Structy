package FiveGraphs;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a grid graph count unique paths from start 0,0 to end grid-1, grid-1
 [    0 1 2 3
 0 [ 0 0 0 0 ]
 1 [ 1 1 0 0 ]
 2 [ 0 0 0 1 ]
 3 [ 0 1 0 0 ]
 ]
 return count int 0,0 -> 0,1 -> 1,2 -> 2,2 -> 3,2 -> 5
*/
public class ShortestBinaryGraph {
    //input grid, start: top left end : bottom right
    // output : shortest path number

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        System.out.println("SHORT PATH:" + shortestPathBFS(grid));
    }

    static int shortestPathBFS(int[][] grid) {
        //Questions : is there min one path from start to end ?
        //Handle edge cases start or end is 1 with size 1
        // if no path return -1

        //Directions to traverse only 4 or 8 assume 8

        //since shortest path we need to use queue using BFS

        //Store in queue co-ordinates traversed + distance

        /*    0 1 2
              1 X
              2 Y
         */

        // Initialize variables, eg directions
        int[][] dirs = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1},
                {-1, 1}, {1, 1}, {1, -1}, {-1, -1},
        };


        Queue<int[]> q = new ArrayDeque<>();

        //Check edge case early
        //
        if( grid[0][0]==1   ||  // start is blocked
            grid[grid.length-1][grid.length-1] == 1  // end is blocked
        ){
            return 0;
        }

        // Add 1st index to Queue
        q.add(new int[]{0, 0, 1});

        // Mark as visited, no need special one since its block is same as visited
        grid[0][0] = 1;
        int ROW = grid.length;
        int COL = grid[0].length;
        int level = 1;

        // Iterate until que is empty
        while (!q.isEmpty()) {
            // Explore each level by queue added i.e explore neighbors added
            //int size = q.size();
            //while(size -- > 0){

            for(int size = q.size() ; size > 0; size--){
                // Get current queue to explore
                int[] point = q.poll();
                assert point != null;
                int r = point[0];
                int c = point[1];
                int d = point[2];
                // check current cell reached end , if so return distance
                if (r == ROW - 1 && c == COL - 1) {
                    return level ; // returing answer when found
                }

                // Explore from current position all new directions
                for (int[] dir : dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    // If not out of bound smaller or bigger, not already visited, not a blocker
                    if ((newR >= 0 && newC > 0) && (newR < ROW && newC < COL) && grid[newR][newC] == 0) {
                        q.add(new int[]{newR, newC, point[2] + 1}); // use level or increment pointers
                        grid[newR][newC] = 1;
                        // add co-ordinates + increment distance
                        // mark cell visited
                    }

                }
            }
            level ++;

        }
        return -1 ;
    }
}
