public class Solution {
    int row=-1,col=-1;
    public void solve(char[][] board) {
        row = board.length;
        if(row <=2){
            return;
        }
        col     = board[0].length;
        if(col <=2){
            return;
        }
        for(int i     =0;i<row;i++){
        if(board[i][0]== 'O'){
                dfs(board,i,0);
            }
            if(board[i][col-1] == 'O'){
                dfs(board,i,col-1);
            }
        }
        for(int i=0;i<col;i++){
            if(board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if(board[row-1][i] == 'O'){
                dfs(board,row-1,i);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs(char[][] board, int i,int j){
        board[i][j] = '*';
        if(i>1 && board[i-1][j] == 'O') dfs(board,i-1,j);
        if(i<row-1 && board[i+1][j] == 'O') dfs(board,i+1,j);
        if(j>1 && board[i][j-1] == 'O') dfs(board,i,j-1);
        if(j < col-1 && board[i][j+1] == 'O') dfs(board,i,j+1);
     }
}
