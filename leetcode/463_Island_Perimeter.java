public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}

// 10.19
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)  {
                    count += 4;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) 
                        count -= 2;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) 
                        count -= 2;
                }
            }
        }
        return count;
    }
}

#python 
class Solution(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        return sum(  sum(map(operator.ne, [0] + row, row + [0]))  for row in grid + map(list, zip(*grid)))
        