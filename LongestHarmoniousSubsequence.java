class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        
        int result = 0;
        int firstStart = 0;
        int secondStart = 0;
        
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i-1]) {

                if (nums[i] - nums[i-1] == 1) {
                    int firstSum = i - firstStart;
                    
                    secondStart = i;
                    while (i < nums.length && nums[i] == nums[secondStart]) {
                        i++;
                    }
                    i--; 
                    
                    int secondSum = i - secondStart + 1;
                    
                    int currentResult = firstSum + secondSum;
                    
                    result = (result < currentResult) ? currentResult : result;
                    
                    firstStart = secondStart;
                } else {
                    firstStart = i;
                }
            }
        }
        
        return result;
    }

}
