class Solution {
    public int helper(int ind,int n,int[] dp){
        if(ind==0)
        return 1;
        if(ind==1)
        return 1;

        if(dp[ind]!=-1) return dp[ind];

        return dp[ind]=helper(ind-1,n,dp)+helper(ind-2,n,dp);
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int x=helper(n,n,dp);
        return x;
    }
}