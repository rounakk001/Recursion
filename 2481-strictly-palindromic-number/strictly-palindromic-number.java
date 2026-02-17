class Solution {

    public boolean isStrictlyPalindromic(int n) {
        
        for(int i = 2; i <= n - 2;i++) {
            
            String converted = funct(n,i);
            
            if(!isPalindrome(converted)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    private String funct(int num, int base) {
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
