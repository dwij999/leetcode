// Description:  
// This Java solution implements the classic Reverse Integer problem. It extracts digits one by one, builds the reversed number, and includes overflow/underflow checks against 32‑bit signed integer limits (-2,147,483,648 to 2,147,483,647). If reversing would exceed these bounds, the function safely returns 0.

// Key points:

// Uses modulo (%) and division (/) to process digits.

// Maintains a running reversed value (rev).

// Prevents overflow/underflow with boundary checks before updating rev.

// Returns the reversed integer or 0 if invalid.




class Solution {
    public int reverse(int x) {
     
     int rev=0;
     int int_max=2147483647;// maximum value of integer
     int int_min=-2147483648;// minimum value of integer
     while(x!=0){
          
          int digit=x%10;// get the last digit of the number
          x=x/10;// remove the last digit from the number
          if(rev>int_max/10 || (rev==int_max/10 && digit>7)) return 0;// check for overflow
          if(rev<int_min/10 || (rev==int_min/10 && digit<-8)) return 0;// check for underflow
          rev=rev*10+digit;// update the reversed number    
     }
     return rev;// return the reversed number
}}
