class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer1 < g.length && pointer2 < s.length){
            if(s[pointer2] >= g[pointer1]){
                pointer1++;
                pointer2++;
            }else{
                pointer2++;
            }
        }
        return pointer1;
    }
}