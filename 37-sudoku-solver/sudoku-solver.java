class Solution {
    public boolean isValid(int row,int col,char c,char[][] board){
         //us particular row aur col mein
         for(int i=0;i<9;i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c)  return false;
         }

         int boxrowstart=(row/3)*3;
         int boxcolstart=(col/3)*3;

         //3x3
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[boxrowstart+i][boxcolstart+j]==c)
                return false;
            }
         }
         return true;
    }

    public boolean solve(char[][] board){

         for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                {
                    for(char c='1';c<='9';c++){
                        if(isValid(i,j,c,board))
                          {
                            board[i][j]=c; //place

                            if(solve(board))
                            return true;

                            board[i][j]='.';  //backtracking

                          }
                         
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {

       solve(board);
    }
}