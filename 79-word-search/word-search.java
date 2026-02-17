class Solution {
    public boolean helper(int i,int j,char[][] board,String word,int n,int m,int k){
        
        if(k>=word.length())
        return true;
        if(i>=n || j<0 || j>=m || i<0 || board[i][j]=='.' || word.charAt(k)!=board[i][j])
        return false;
        if(word.length()==1 && word.charAt(k)==board[i][j])
        return true;

        board[i][j]='.';  //mark as dot wahi visited na bana ke ye kr de rahe

        boolean temp=false;

        int di[]={-1,0,0,1};
        int dj[]={0,1,-1,0};

        for(int x=0;x<4;x++){
            temp=temp || helper(i+di[x],j+dj[x],board,word,n,m,k+1);
        }
        board[i][j]=word.charAt(k);

        return temp;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        if(n==0)
        return false;
        // if(word.length()==0)
        // return false;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(helper(i,j,board,word,n,m,0))
                    return true;
                }
            }
        }
        return false;
    }
}