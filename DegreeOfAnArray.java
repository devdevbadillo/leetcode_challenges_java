/*
  Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
  
  Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

  Example 1:
    Input: nums = [1,2,2,3,1]
    Output: 2
    
    Explanation: 
      The input array has a degree of 2 because both elements 1 and 2 appear twice.
      Of the subarrays that have the same degree:
      [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
      The shortest length is 2. So return 2.
      
  Example 2:
    Input: nums = [1,2,2,3,1,4,2]
    Output: 6
    
    Explanation: 
      The degree is 3 because the element 2 is repeated 3 times.
      So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> firstIndex = new HashMap<>();
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            lastIndex.put(num, i);

            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }

            degree = Math.max(degree, frequency.get(num));
        }

        int minLength = nums.length;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {

            if (entry.getValue() == degree) {
                int num = entry.getKey();
                minLength = Math.min(minLength, lastIndex.get(num) - firstIndex.get(num) + 1);
            }
            
        }

        return minLength;
    }
}
