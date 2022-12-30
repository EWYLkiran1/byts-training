class Solution {
public:

    string Stringify(int a,int b,int x,int y){

        return to_string(a)+" "+to_string(b)+" "+to_string(x)+" "+to_string(y);

    }

    int solve(int i,int j,int a,int b,string& s1,string& s2,unordered_map<string,bool>& dp){

        string nums = Stringify(i,j,a,b);

        if(dp.find(nums)!=dp.end()) return dp[nums];
        
        if(a==b) return s1[i]==s2[b];

        for(int cut=0;cut<(j-i);cut++){
            
           bool noSwap  = solve(i,i+cut,a,a+cut,s1,s2,dp) && solve(i+cut+1,j,a+cut+1,b,s1,s2,dp);

            bool swap = solve(i+cut+1,j,a,b-cut-1,s1,s2,dp) && solve(i,i+cut,b-cut,b,s1,s2,dp);

            if(swap||noSwap) return dp[nums]=true ;
        }

        return dp[nums]=false; 

    }

    bool isScramble(string s1, string s2) {

        unordered_map<string,bool> dp ;

        return solve(0,s1.length()-1,0,s2.length()-1,s1,s2,dp);

    }
};