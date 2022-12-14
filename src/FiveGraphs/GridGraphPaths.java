package FiveGraphs;

import java.util.List;

/**
 * Given a grid graph count unique paths from start 0,0 to end grid-1, grid-1
  [    0 1 2 3
   0 [ 0 0 0 0 ]
   1 [ 1 1 0 0 ]
   2 [ 0 0 0 1 ]
   3 [ 0 1 0 0 ]
 ]

 //paths - 0,0 -> 0,1 -> 0,2
                            -> 0,3 -> 1,3 -> 1,2 -> 2,2  ->3,2 -> 3,3
                            -> 1,2 -> 2,2 -> 3,2 -> 3,3
 */
public class GridGraphPaths {
    class GraphNode{
        int val;
        List<GraphNode> neighbors ;
    }

    public static void main(String[] args){
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int r = 0, c = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int paths = countPathsDFS(grid,r,c, visited );
        System.out.println("Paths:" + paths );

    }

    public static int countPathsDFS(int[][] grid, int r, int c, int[][] visited ){
        // Initiation of variables ?
            // identify end rows,columns
        int paths = 0;
        int ROWS = grid.length; int COLS = grid[0].length;

        // Handle base condition
            // Invalid counts
                // out of bounds too small or too big, can take
                // block cell
                // already visited
                // reached end

        if( (Math.min(r,c) < 0) ||
        ( r == ROWS || c== COLS ) || // max since rows, col might not be equal size
        ( visited[r][c] )== 1  || // already visited
                   ( grid[r][c] )== 1) // blocked node
        {
            return 0;
        }
            // Valid counts
        if( r == ROWS -1 && c == COLS-1){
            return 1;
        }
                // reached end
        // Mark cell visited for every iteration
        visited[r][c] = 1;

        // Move every direction up, down, left, right and count result
        paths += countPathsDFS(grid, r,c-1 , visited); //go left
        paths += countPathsDFS(grid, r,c+1 , visited); //go right
        paths += countPathsDFS(grid, r-1,c , visited); //go up
        paths += countPathsDFS(grid, r+1,c , visited); //go down

        // Back tracking cell visited
        visited[r][c] = 0;
        return paths;
    }
}
