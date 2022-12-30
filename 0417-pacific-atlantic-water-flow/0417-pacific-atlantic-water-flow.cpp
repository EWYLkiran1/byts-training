class Solution {
public:
    void dfs(int row, int col, vector<vector<int>>& ocean, vector<vector<int>>&heights ) {
        int dr[4] = {0, -1, 0, 1};
        int dc[4] = {-1, 0, 1, 0};
        int m = heights.size();
        int n = heights[0].size();
        ocean[row][col] = 1;
        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !ocean[nrow][ncol] && heights[nrow][ncol]>=heights[row][col]) {
                dfs(nrow, ncol, ocean, heights);
            }
        }
    }
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int dr[4] = {0, -1, 0, 1};
        int dc[4] = {-1, 0, 1, 0};
        int m = heights.size();
        int n = heights[0].size();
        vector<vector<int>> pacific(m, vector<int>(n,0)), atlantic(m, vector<int>(n,0));

        vector<vector<int>> ans;
        for(int i=0; i<n; i++) {
            dfs(0, i, pacific, heights);
            dfs(m-1, i, atlantic, heights);
        }
        for(int i=0; i<m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n-1, atlantic, heights);
        }
        for(int i=0;i<m ;i++) {
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]) {
                    vector<int> temp;
                    temp.push_back(i);
                    temp.push_back(j);
                    ans.push_back(temp);
                }
            }
        }
        return ans;
    } 

};