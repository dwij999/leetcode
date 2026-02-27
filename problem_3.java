// ✅ Approach 1: Sliding Window + HashSet

// Use two pointers (left, right) to maintain a sliding window.

// Store characters of the current window in a HashSet.

// If the current character is not in the set, expand the window.

// If a duplicate is found, shrink the window from the left until the duplicate is removed.

// Track the maximum window size during the process.

// Time Complexity: O(n)
// Space Complexity: O(n)

--------------------------------------------------------
class Solution {
    public int lengthOfLongestSubstring(String s) {
     int max_length=0;
     int left=0;
     int right=0;
     Set<String> longestSubstring = new HashSet<>();
     while(s.length()>right){
          if(!longestSubstring.contains(String.valueOf(s.charAt(right)))){
               longestSubstring.add(String.valueOf(s.charAt(right)));
               right++;
               max_length=Math.max(max_length,longestSubstring.size());
          }
          else{
               longestSubstring.remove(String.valueOf(s.charAt(left)));
               left++;
          }


     }
     return max_length;
    }
    
}
=================================================================================




//   ✅ Approach 2: Sliding Window + HashMap (Optimized)

// Use a HashMap<Character, Integer> to store the last index of each character.

// When a duplicate character is found, directly move left to lastIndex + 1 (if inside the current window).

// This avoids removing elements one by one.

// Update maximum length using right - left + 1.

// Time Complexity: O(n)
// Space Complexity: O(n)
  -----------------------------------------------------------------------------------

class Solution {
    public int lengthOfLongestSubstring(String s) {
     int maxLength=0;
     int left=0;
     int right=0;
     
     HashMap<Character,Integer> set=new HashMap<>();
     while(right<s.length()){
     if (set.containsKey(s.charAt(right))){
          int lastIndex=set.get(s.charAt(right));
          if (lastIndex>=left){
               left=lastIndex+1;
          }
          
     }
     set.put(s.charAt(right),right);
     maxLength=Math.max(maxLength,right-left+1);
     right++;}
     return maxLength;
    }
}


