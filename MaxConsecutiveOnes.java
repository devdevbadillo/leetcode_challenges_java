/*
    Given a binary array nums, return the maximum number of consecutive 1's in the array.

    Example 1:
        Input: nums = [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
        
    Example 2:
        Input: nums = [1,0,1,1,0,1]
        Output: 2
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] == 1){
                
                count++;

            } else{
                
                if( maxConsecutive < count ){
                    maxConsecutive = count;
                } 

                count = 0;
            }

            if( i + 1 == nums.length && maxConsecutive < count){
                maxConsecutive =  count;
            }
        }

        return maxConsecutive;
    }
}
