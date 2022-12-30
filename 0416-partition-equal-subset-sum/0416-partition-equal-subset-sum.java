class Solution {
    private boolean knapsackMemoizationUtil(int[] nums, int n, int target, Boolean[][] dp) {
		if (n == 0) {
			return target == 0 ? true : false;
		}
		if (dp[n][target] != null) {
			return dp[n][target];
		}
		if (nums[n - 1] > target) {
			dp[n][target] = knapsackMemoizationUtil(nums, n - 1, target, dp);
		} else {
			dp[n][target] = knapsackMemoizationUtil(nums, n - 1, target - nums[n - 1], dp)
					|| knapsackMemoizationUtil(nums, n - 1, target, dp);
		}
		return dp[n][target];
	}

	private boolean memoization(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
		return knapsackMemoizationUtil(nums, nums.length, sum/2, dp);
	}
    private boolean knapsackTabulation(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		}
        int target = sum / 2;
		boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[nums.length][target];
	}
    public boolean canPartition(int[] nums) {
        // return memoization(nums);
        return knapsackTabulation(nums);
    }
}