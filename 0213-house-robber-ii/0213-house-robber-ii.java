class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int nums1[]=new int[nums.length-1];
        int nums2[]=new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++) nums1[i]=nums[i];
        for(int i=0;i<nums.length-1;i++) nums2[i]=nums[i+1];

        int dp[][]=new int[nums1.length+1][2];
        for(int i=1;i<=nums1.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums1[i-1]+dp[i-1][0];
        }
        int sum1 = Math.max(dp[nums1.length][0],dp[nums1.length][1]);

        int dp1[][]=new int[nums2.length+1][2];
        for(int i=1;i<=nums2.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums2[i-1]+dp[i-1][0];
        }
        int sum2 = Math.max(dp[nums2.length][0],dp[nums2.length][1]);

        return Math.max(sum1,sum2);
    }
}