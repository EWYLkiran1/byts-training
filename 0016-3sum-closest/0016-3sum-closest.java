class Solution {
    public int threeSumClosest(int[] nums, int target) {
         int result =nums[0] + nums[1] +nums[nums.length - 1];
         Arrays.sort(nums);
        for(int i = 0; i< nums.length-2; i++){
            int a_pointer = i+1;
            int b_pointer = nums.length - 1;
            
            while(a_pointer < b_pointer){
                int currSum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if(currSum > target) b_pointer -= 1;
                else a_pointer +=1;
                
                if(Math.abs(currSum - target) < Math.abs(result - target)){
                    result = currSum;
                }
            }
                
        }
       return result;
  }
}    