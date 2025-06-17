/*

Given two strings 's' and 't', determine if they are isomorphic. Two strings 's' and 't' are isomorphic if the characters in 's' can be replaced to get 't.'

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

  Example 1:
    Input: s = "egg", t = "add"
    Output: true
    
  Explanation:
    The strings s and t can be made identical by:
    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

  Example 2:
    Input: s = "foo", t = "bar"
    Output: false

  Explanation:
    The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

  Example 3:
    Input: s = "paper", t = "title"
    Output: true
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sToTMap = new char[256]; 
        char[] tToSMap = new char[256]; 

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sToTMap[charS] == 0) { 
                sToTMap[charS] = charT; 
            } else {
                if (sToTMap[charS] != charT) return false;
            }

            if (tToSMap[charT] == 0) {
                tToSMap[charT] = charS; 
            } else {
                if (tToSMap[charT] != charS) return false;
            }
        }

        return true; 
    }
}
