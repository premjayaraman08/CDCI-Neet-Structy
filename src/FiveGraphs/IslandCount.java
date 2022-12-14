package FiveGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        Solution s = new Solution();
        //int var = s.numIslandsDFS(grid);
        int var = s.numIslandsBFS(grid);
        System.out.println ("OP: " + var);
    }




    public static class Solution {

        public int numIslandsBFS(char[][] grid) {

            int count = 0;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    Queue<int[]> q = new LinkedList<>();
                    int r = 0;
                    int c = 0;

                    //Iterating each grid
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        //add to que
                        q.add(new int[]{i, j});
                        //mark visited
                        grid[i][j] = '0';
                        // initiate BFS
                        BFS(grid, q, visited);
                        count++;
                    }

                }
            }
            return count;
        }

        public void BFS(char[][] grid, Queue<int[]> q,boolean[][] visited){
            // Initialize variables
            int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


            //Iterate until q is empty
            while(!q.isEmpty()){
                //Iterate all items in q or that level
                for(int size = q.size(); size>0 ; size --){
                    int[] pos = q.poll();
                    assert pos != null;
                    int cr = pos[0];
                    int cc = pos[1];

                    //Iterate each direction
                    for(int[] dir: dirs){
                        int newr = cr + dir[0];
                        int newc = cc + dir[1];

                        //if out of bounds continue
                        // inbounds
                        if(newr<0 || newc<0 || newr>=grid.length || newc>= grid[0].length){
                            continue;
                        }
                        //if water or already visited
                        if(grid[newr][newc] == '0'){
                            continue;
                        }

                        if(visited[newr][newc]){
                            continue;
                        }

                        visited[newr][newc] = true;
                        q.add(new int[]{newr, newc});

                    }
                }
            }

        }
        Solution() {

        }

        public int numIslandsDFS(char[][] grid) {
            //Given cell having string 1s or 0s- water //O/P : no of islands
            //Start from top left and iterate till bottom right

            //Initialize variables, visited
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (explore(grid, i, j, visited)) {
                        count++;
                    }
                }
            }

            //explore BFS option to check for new island

            //if new island increment counter and return final count
            return count;
        }

        public boolean explore(char[][] grid, int r, int c, boolean[][] visited) {
            // Handle failure cases
            // row out of bounds
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
                return false;
            }

            //row,col already visited return false
            if (visited[r][c]) {
                return false;
            }

            // not water return false
            if (grid[r][c] == '0') {
                return false;
            }

            // mark current row as visited
            visited[r][c] = true;

            //directions
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            //From current position check all on directions
            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                explore(grid, newR, newC, visited);
            }
            return true;
        }
    }
}