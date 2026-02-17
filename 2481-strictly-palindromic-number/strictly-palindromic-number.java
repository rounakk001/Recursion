class Solution {

    public boolean isStrictlyPalindromic(int n) {
        
        for(int base = 2; base <= n - 2; base++) {
            
            String converted = convertToBase(n, base);
            
            if(!isPalindrome(converted)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    private String convertToBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            sb.append(num % base);
            num /= base;
        }
        
        return sb.reverse().toString();
    }
    
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
