//solution 1: DFS
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

//solution 2: BFS
public class Solution {
    int row=-1,col=-1;
    class Point{
        int x;
        int y;
        Point(int _x,int _y){
            x = _x; y = _y;
        }
    }
    public void solve(char[][] board) {
        row = board.length;
        if(row <=2){
            return;
        }
        col = board[0].length;
        if(col <=2){
            return;
        }
        Queue<Point> q= new LinkedList<Point>();
        for(int i =0;i<row;i++){
            if(board[i][0]== 'O'){
                q.add(new Point(i,0));
            }
            if(board[i][col-1] == 'O'){
                q.add(new Point(i,col-1));
            }
        }
        for(int i=0;i<col;i++){
            if(board[0][i] == 'O'){
                q.add(new Point(0,i));
                
            }
            if(board[row-1][i] == 'O'){
                 q.add(new Point(row-1,i));
                
            }
        }
        while(q.size() > 0){
            Point cur = q.remove();
            int i = cur.x,j=cur.y;
            board[i][j] = '*';
            if(i>0 && board[i-1][j] == 'O'){
                q.add(new Point(i-1,j));
            }
            if(i<row-1 && board[i+1][j] == 'O'){
                q.add(new Point(i+1,j));
            }
            if(j>0 && board[i][j-1] == 'O'){
                 q.add(new Point(i,j-1));
            }
            if(j<col-1 && board[i][j+1] == 'O'){
                 q.add(new Point(i,j+1));
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
    
}
