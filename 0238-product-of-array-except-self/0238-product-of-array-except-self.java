class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLength = nums.length, prefixProduct = 1, postfixProduct = 1;
        int[] ans = new int[arrLength];

        for (int i = 0; i < arrLength - 1; i++) {
            prefixProduct *= nums[i];
            ans[i + 1] = prefixProduct;
        }

        ans[0] = 1;

        for (int i = arrLength - 1; i > 0; i--) {
            postfixProduct *= nums[i];
            ans[i - 1] *= postfixProduct;
        }

        return ans;
    }
}