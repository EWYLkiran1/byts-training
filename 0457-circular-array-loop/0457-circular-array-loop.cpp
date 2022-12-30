class Solution {
public:
    bool circularArrayLoop(vector<int>& nums) {
        int n = nums.size();
        // we will try to find cycle for every node as a starting point 
        for(int i=0;i<n;i++){
            // so starting point is i and till we reach i or we reach at visited node
            vector<bool> vis(n,0);
            vis[i] = 1;
            int pt = 0; // nodes moving right
            int nt = 0; // nodes moving left
            // nxt will store next index that need to be visited
            int nxt = (i + nums[i])%n;
            pt++;
            // if going left 
            if(nums[i] < 0){ 
                // if out of bound
                if(nxt < 0) nxt = nxt + n; 
                pt--; nt++; 
            }
            // while we do not get loop of visited node or reach first node
            while(nxt != i && !vis[nxt]){
                vis[nxt] = 1;
                int tem = nxt;
                nxt = (tem + nums[tem])%n; pt++;
                if(nums[tem] < 0){ 
                    if(nxt < 0) nxt = nxt + n; 
                    pt--; nt++; 
                }
            }
            if(nxt == i && (pt + nt) > 1 && (pt == 0 || nt == 0)) return 1;
        }
        return 0;
    }
};
