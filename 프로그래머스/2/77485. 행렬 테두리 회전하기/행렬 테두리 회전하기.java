import java.util.*;

class Solution {
    public int[] rotate(int[][] grid, int[][] queries) {
        int[] result = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int x1 = q[0] - 1, y1 = q[1] - 1, x2 = q[2] - 1, y2 = q[3] - 1;
            int temp = grid[x1][y2];
            int min = temp;

            for (int y = y2 - 1; y >= y1; y--) {
                grid[x1][y + 1] = grid[x1][y];
                min = Math.min(min, grid[x1][y]);
            }

            for (int x = x1 + 1; x <= x2; x++) {
                grid[x - 1][y1] = grid[x][y1];
                min = Math.min(min, grid[x][y1]);
            }

            for (int y = y1 + 1; y <= y2; y++) {
                grid[x2][y - 1] = grid[x2][y];
                min = Math.min(min, grid[x2][y]);
            }

            for (int x = x2 - 1; x >= x1; x--) {
                grid[x + 1][y2] = grid[x][y2];
                min = Math.min(min, grid[x][y2]);
            }

            grid[x1 + 1][y2] = temp;
            result[idx++] = min;
        }

        return result;
    }

    public int[][] initializeGrid(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = i * cols + j + 1;
            }
        }
        return grid;
    }

    public int[] solution(int rows, int cols, int[][] queries) {
        int[][] grid = initializeGrid(rows, cols);
        return rotate(grid, queries);
    }
}
