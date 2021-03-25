package LeetCode;

public class prob994 {

    public static int orangesRotting(int[][] grid) {
        //make sure the grid is at least a 2x2,
        //otherwise do something based on the one value that exists

        int out = 0;
        int[][] mem = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[j=i].length; j++) {
                mem[i][j] = grid[i][j];
            }
        }

        if (grid.length == 1 && grid[0].length == 1) {
            //1x1 grid
            switch (grid[0][0]) {
                case 0:
                case 1:
                    return -1;
                case 2:
                    return 0;
            }
        } else {
            int x = 0;
            int y = 0;
            boolean rot = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        //there can only be one rotten right?
                        rot = true;
                        x = i;
                        y = j;
                        break;
                    }
                }
            }
            boolean already = false;
            if (rot) {
                for (int i = 0; i < mem.length; i++) {
                    for (int j = 0; j < mem[i].length; j++) {
                        if (mem[i][j] == 1) {
                            //if three is a fresh fruit adjacent to the rotten fruit
                            if (Math.abs(x-i) == 1) {
                                if (!already) {
                                    out++;
                                    already = true;
                                }
                                mem[i][j] = 2;
                            }
                            if (Math.abs(y-j) == 1) {
                                if (!already) {
                                    out++;
                                    already = true;
                                }
                                mem[i][j] = 2;
                            }

                        }
                    }
                }
            } else {
                return -1;
            }
        }
        //null?
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0}, {0, 0}};
        System.out.println(orangesRotting(grid));
    }

}
