class Solution {
public:
    int minDistance(string str1, string str2) {
        int m = str1.length();
        int n = str2.length();
        int k = max(m,n);
        vector<int> prev(k+1,0),cur(k+1,0);
         //Base cases for exhaustion of str1 and str2
         for(int j=0;j<=n;j++){
             prev[j] = j;
         }
        for(int i=1;i<=m;i++){
            cur[0]=i;
            for(int j=1;j<=n;j++){

               if(str1[i-1]==str2[j-1]){

                   cur[j]=0+prev[j-1];
               }
               else{
                   cur[j]= 1 + min(prev[j-1],min(prev[j],cur[j-1]));
               }
            }
            prev = cur;
        }
       return prev[n];
    }
};