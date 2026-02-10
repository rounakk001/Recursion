class Solution {
    int idx=0;   //global variable
    int sign=1;
    public int myAtoi(String s) {
        //chal saale leading spaces se bach
        while(idx<s.length() && s.charAt(idx)==' ')
        idx++;

        //handle sign
        if(idx<s.length() && (s.charAt(idx)=='+' || s.charAt(idx)=='-'))
        {
            sign=(s.charAt(idx)=='-')?-1:1;
            idx++;
        }

        return sign* helper(s,0);
    }

    public int helper(String s,int num){
        //base case  ya to length ke bahar chala gaya ya to character digit hai hi nahi
        if(idx>=s.length() || !Character.isDigit(s.charAt(idx)))
        return num;
 

       int digit=s.charAt(idx)-'0';
        idx++;

        //overflow bhi pakadna hai
        if(num>(Integer.MAX_VALUE-digit)/10)
        return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;

        return helper(s,num*10+digit);
    }
}