
// This solution finds the Longest Palindromic Substring in a given string using Dynamic Programming.

// A 2D boolean DP table tracks whether substrings are palindromes.

// Single characters and equal adjacent pairs are initialized as palindromes.

// For substrings of length ≥ 3, it checks if the first and last characters match and if the inner substring is also a palindrome.

// Updates the starting index and maximum length whenever a longer palindrome is found.

// Finally, returns the longest palindromic substring.

// Time Complexity: 
// 𝑂(𝑛2)
  
// Space Complexity: 
// 𝑂(𝑛2)


class Solution {
     public String longestPalindrome(String s) {
          int n = s.length();// string length
          boolean[][] dp = new boolean[n][n];// dp array
          for (int i = 0; i < n; i++) {
               dp[i][i] = false;// single character is palindrome
          }
          int start = 0;// it will store the starting index of longest palindrome
          int max_length = 1;// it will store the length of longest palindrome
          for (int i = 0; i < n - 1; i++) {
               dp[i][i] = true;// every single character is a palindrome]

          }
          for (int j = 0; j < n - 1; j++) {
               if (s.charAt(j) == s.charAt(j + 1)) {
                    dp[j][j + 1] = true;// if two adjacent characters are same then it is a palindrome
                    start = j;// update the starting index of longest palindrome
                    max_length = 2;// update the length of longest palindrome
               }
          }
          // check for palindromes of length greater than 2
          for (int k = 3; k <= n; k++) {
               for (int i = 0; i <= n - k; i++) { // i is the starting indexof the substring
                    int j = i + k - 1;// j is the ending index of the substring
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) { // if the first and last characters are same
                                                                          // and the substring between them is a
                                                                          // palindrome
                         dp[i][j] = true;// update the dp array

                         if (k > max_length) {
                              start = i;// update the starting index of longest palindrome
                              max_length = k;
                         } // update the length of longest palindrome

                    }

               }

          }
          return s.substring(start, start + max_length);// return the longest palindrome substring
     }

}
