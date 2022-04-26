class Solution {
    public int projectionArea(int[][] grid) {
        int a1 = 0, a2 = 0, a3 = 0, z1 = 0, z2 = 0;
        for (int i = 0; i < grid.length; i++) {
            int y = 0;
            for (int j = 0; j < grid[i].length; j++) {
                a1 += grid[i][j] > 0 ? 1 : 0;
                y = Math.max(y, grid[i][j]);
            }
            z1 = Math.max(z1, grid[i][0]);
            z2 = Math.max(grid[i][1], z2);
            a2 += y;
        }
        a3 = z1 + z2;
        return a1 + a2 + a3;
    }
}
