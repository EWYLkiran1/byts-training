class Solution {
public:
    typedef pair<int , int> p;
    // TC = O(2^S)
    // SC = O(S) (stack space)
    int fun(int m , int n , int idx , vector<p> &cnt){
        if((idx == -1) || (m==0 && n==0)) return 0;
        int pick = 0 , notPick = 0 , c0 = cnt[idx].first , c1 = cnt[idx].second;
        if(m-c0 >=0 && n-c1>=0) pick = fun(m-c0 , n-c1 , idx-1 , cnt) + 1;
        notPick = fun(m , n , idx-1 , cnt);
        return max(pick , notPick);
    }

    // TC = O(S*M*N)
    // SC = O(S*M*N) (dp 3d-matrix) + O(S) (stack space)
    int memofun(int m , int n , int idx , vector<p> &cnt , vector<vector<vector<int>>> &dp){
        if((m==0 && n==0)) return 0;
        if(dp[m][n][idx] != -1) return dp[m][n][idx];
        int pick = 0 , notPick = 0 , c0 = cnt[idx].first , c1 = cnt[idx].second;
        if(idx == 0) return (m-c0>=0 && n-c1>=0)?1:0;
        if(m-c0 >=0 && n-c1>=0) pick = memofun(m-c0 , n-c1 , idx-1 , cnt , dp) + 1;
        notPick = memofun(m , n , idx-1 , cnt , dp);
        return dp[m][n][idx] = max(pick , notPick);
    }

    // TC = O(S*M*N)
    // SC = O(S*M*N) (dp 3d-matrix)
    int tabfun(int m , int n , vector<p> &cnt , vector<vector<vector<int>>> &dp){
        int s = cnt.size();
        for(int idx=0; idx<s; idx++){
            for(int i=0; i<=m; i++){
                for(int j=0; j<=n; j++){
                    int pick = 0 , notPick = 0 , c0 = cnt[idx].first , c1 = cnt[idx].second;
                    if(idx==0) {
                        dp[0][i][j] = (i-c0 >=0 && j-c1>=0)?1:0;
                        continue;
                    }
                    if(i-c0 >=0 && j-c1>=0) pick = dp[idx-1][i-c0][j-c1] + 1;
                    notPick = dp[idx-1][i][j];
                    dp[idx][i][j] = max(pick , notPick);
                }
            }
        }
        return dp[s-1][m][n];
    }

    // TC = O(S*M*N)
    // SC = O(M*N) (dp 2d-matrix)
    int spaceOptimization(int m , int n , vector<p> &cnt){
        vector<vector<int>> dp(m+1 , vector<int>(n+1 , 0));
        int s = cnt.size();
        for(int idx=0; idx<s; idx++){
            for(int i=m; i>=0; i--){
                for(int j=n; j>=0; j--){
                    int pick = 0 , notPick = 0 , c0 = cnt[idx].first , c1 = cnt[idx].second;
                    if(idx==0) {
                        dp[i][j] = (i-c0 >=0 && j-c1>=0)?1:0;
                        continue;
                    }
                    if(i-c0 >=0 && j-c1>=0) pick = dp[i-c0][j-c1] + 1;
                    notPick = dp[i][j];
                    dp[i][j] = max(pick , notPick);
                }
            }
        }
        return dp[m][n];
    }

    int findMaxForm(vector<string>& strs, int m, int n) {
        vector<p> cnt;
        int s = strs.size();
        for(int i=0; i<s; i++){
            int c0=0 , c1=0 , s1 = strs[i].size();
            for(int j=0; j<s1; j++){
                if(strs[i][j] == '1') c1++;
                else c0++;
            }
            cnt.push_back({c0 , c1});
        }
        // return fun(m , n , s-1 , cnt);
        // vector<vector<vector<int>>> dp(m+1 , vector<vector<int>>(n+1 , vector<int>(s , -1)));
        // return memofun(m , n , s-1 , cnt , dp);
        // vector<vector<vector<int>>> dp(s , vector<vector<int>>(m+1 , vector<int>(n+1 , 0)));
        // return tabfun(m , n , cnt , dp);
        return spaceOptimization(m , n , cnt);
    }
};
