class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int minCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(minCount < count)
                    minCount = count;
                count = 0;
            }
            else{
                count++;
            }
        }
        return Math.max(minCount, count);
    }
}