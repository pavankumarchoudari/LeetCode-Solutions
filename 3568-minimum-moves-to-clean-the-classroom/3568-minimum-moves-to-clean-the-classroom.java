import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startX = -1, startY = -1;
        int litterCount = 0;
        int[][] litterMap = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterMap[i], -1);
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterMap[i][j] = litterCount++;
                }
            }
        }
        
        int targetMask = (1 << litterCount) - 1;
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0, energy, 0});
        bestEnergy[startX][startY][0] = energy;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int mask = curr[2];
            int currEnergy = curr[3];
            int steps = curr[4];
            
            if (mask == targetMask) {
                return steps;
            }
            
            if (currEnergy == 0) {
                continue;
            }
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && classroom[nx].charAt(ny) != 'X') {
                    int nextEnergy = currEnergy - 1;
                    int nextMask = mask;
                    
                    if (classroom[nx].charAt(ny) == 'L') {
                        nextMask |= (1 << litterMap[nx][ny]);
                    }
                    
                    if (classroom[nx].charAt(ny) == 'R') {
                        nextEnergy = energy;
                    }
                    
                    if (nextEnergy > bestEnergy[nx][ny][nextMask]) {
                        bestEnergy[nx][ny][nextMask] = nextEnergy;
                        queue.offer(new int[]{nx, ny, nextMask, nextEnergy, steps + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
