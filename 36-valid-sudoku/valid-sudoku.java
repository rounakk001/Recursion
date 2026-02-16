class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];
            
            for (int j = 0; j < 9; j++) {
                
                // Row check rr rahe
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) return false;
                    row[num] = true;
                }
                
                // Column check kar rahe hai
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) return false;
                    col[num] = true;
                }
                
                // 3x3 box check  check kar rahe
                int boxRow = 3 * (i / 3) + j / 3;
                int boxCol = 3 * (i % 3) + j % 3;
                
                if (board[boxRow][boxCol] != '.') {
                    int num = board[boxRow][boxCol] - '1';
                    if (box[num]) return false;
                    box[num] = true;
                }
            }
        }
        
        return true;
    }
}
