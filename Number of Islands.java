public class Solution {
    private int row=0,col=0;
    private boolean dfs(char[][] grid,int i,int j){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] == '0'){
            return false;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        return true;
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        row = grid.length;
        if(row == 0){
            return 0;
        }
        col = grid[0].length;
        if(col == 0){
            return 0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1' && dfs(grid,i,j)){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
