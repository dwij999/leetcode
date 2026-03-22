class Solution {
    public boolean isPalindrome(int x) {
        String s= Integer.toString(x);
        String t="";

        int index=s.length()-1;
        while (index>=0){
            t=t+s.charAt(index);
            index--;}
        if (t.equals(Integer.toString(x))){
            return true;
        }else{return false;}




        
        
    }
}
