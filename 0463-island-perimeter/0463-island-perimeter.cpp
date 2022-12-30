class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int r = grid.size(), c = grid[0].size(), ans=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    if ((j-1) < 0 || grid[i][j-1] == 0) ans++;
                    if ((j+1) == c || grid[i][j+1] == 0) ans++;
                    if ((i-1) < 0 || grid[i-1][j] == 0) ans++;
                    if ((i+1) == r || grid[i+1][j] == 0) ans++;
                }
            }
        }
        return ans;        
    }
};