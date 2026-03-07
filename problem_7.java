
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
