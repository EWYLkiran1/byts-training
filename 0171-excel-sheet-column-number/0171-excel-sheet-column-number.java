class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int p = 0;
        for(int i=columnTitle.length()-1; i>=0; i--){
            char c = columnTitle.charAt(i);
            int asci = (int)c - 'A' + 1;
            ans += asci*Math.pow(26,p);
            p++;
        }
        return ans;
    }
}
