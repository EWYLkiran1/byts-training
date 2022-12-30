class Solution {
    public int hIndex(int[] arr) {
        int s = 0; 
        int e = arr.length;
        int ei = arr.length;
        int ans = 0;
        while(s<e){
            int mid = (s+e)/2;
            if (ei - mid >arr[mid]){
                ans = Math.max(arr[mid], ans);
                s = mid+1; 
            }
            else{
                ans = Math.max(ei-mid , ans);
                e = mid;
            }
        }
        return ans;
    }
}