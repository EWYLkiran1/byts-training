class Solution {
    int[] bool=null;
    public int rob(int[] nums) {
         bool=new int[nums.length];
          Arrays.fill(bool,-1);
          return max(nums,nums.length-1);
    }
    public int max(int[] nums,int n){
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(bool[n]!=-1) return bool[n];
        int lh=nums[n]+max(nums,n-2);
        int rh=0+max(nums,n-1);
        bool[n]=Math.max(lh,rh);
        return Math.max(lh,rh);
    }
}