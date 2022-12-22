public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < result.length; i ++) {
            result[i] = -1;
        }
        for (int i = 0; i < 2 * result.length; i ++) {
            int num = nums[i % result.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < result.length) {
                stack.push(i);
            }
        }
        return result;
    }
}