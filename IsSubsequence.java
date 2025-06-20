/* 
  Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
  
  A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters 
  without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

  Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true
  Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false
  
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if( t.contains(s) ) return true;

        int currentIndex = t.indexOf( String.valueOf( s.charAt(0) ) );
        if( currentIndex < 0) return false;

        t = t.replaceFirst( String.valueOf( s.charAt(0) ), "");

        for(int i = 1; i < s.length(); i++){
            int nextIndex = t.indexOf( String.valueOf( s.charAt(i) ) );

            if (i + 1 == s.length() && nextIndex != t.lastIndexOf( String.valueOf( s.charAt(i) ) ) ){
                nextIndex = t.lastIndexOf( String.valueOf( s.charAt(i) ) );
            }

            if( nextIndex < 0 || currentIndex > nextIndex) return false;

            t = t.replaceFirst( String.valueOf( s.charAt(i) ), "");
          
            currentIndex = nextIndex;
        }

        return true;
    }
}
