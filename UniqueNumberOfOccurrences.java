/*
    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

    Example 1:  
        Input: arr = [1,2,2,1,1,3]
        Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

    Example 2:
        Input: arr = [1,2]
        Output: false

    Example 3:
        Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
        Output: true
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            frequency.put( num, frequency.getOrDefault(num, 0) + 1);
        }

       Set<Integer> uniqueValues = frequency.values().stream().distinct().collect(Collectors.toSet());

        int sum = 0;

        for (Integer uniqueValue: uniqueValues) {
             sum += uniqueValue;
        }

        return sum == arr.length;
    }
}
