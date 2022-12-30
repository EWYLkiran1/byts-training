class Solution {
    public int minMoves(int[] nums) {
        int count = 0;
        int lowest = Integer.MAX_VALUE;

        for(int num : nums){
            lowest = Math.min(lowest, num);
        }

        for(int num : nums){
            count += num - lowest;
        }
    return count;
    }
}